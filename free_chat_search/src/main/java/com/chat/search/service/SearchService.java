package com.chat.search.service;

import com.chat.backcontroll.entity.SearchAnalyze;
import com.chat.search.common.constants.NumConstant;
import com.chat.search.common.enums.ExceptionEnum;
import com.chat.search.common.exception.ChatException;
import com.chat.search.common.redis.PersonalRedisUtil;
import com.chat.search.common.thread.ThreadUtil;
import com.chat.search.common.utils.HttpsUtil;
import com.chat.properties.NetSource;
import com.chat.properties.RedisConfig;
import com.chat.search.client.SearchAnalyzeClient;
import com.chat.search.pojo.IntoMessage;

import com.chat.search.pojo.IntoMessageReqDTO;
import com.chat.search.repository.IntoMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * 描述:es查询
 *
 * @Author: Ldy
 * @Date 2019/11/7 10:12
 **/
@Service
@Slf4j
@EnableConfigurationProperties({NetSource.class,RedisConfig.class})
public class SearchService {
    @Autowired
    private IntoMessageRepository intoMessageRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private NetSource netSource;
    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private PersonalRedisUtil personalRedisUtil;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Value("${searchFanoutExchange}")
    private String searchFanoutExchange;
    @Autowired
    private SearchAnalyzeClient searchAnalyzeClient;
    /**
     * 描述: 查询所有数据
     *
     * @return java.util.List<com.chat.search.pojo.IntoMessageResVo>
     **/
    public List<IntoMessage> searchAll() {
        Iterable<IntoMessage> all = intoMessageRepository.findAll();
        List<IntoMessage> intoMessageList = new ArrayList<>();
        all.forEach(a -> intoMessageList.add(a));
        return intoMessageList;
    }

    /**
     * 描述:条件查询
     *
     * @return java.util.List<com.chat.search.pojo.IntoMessage>
     **/
    public List<IntoMessage> searchWhere(IntoMessageReqDTO intoMessageReqDTO) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("all", intoMessageReqDTO.getAll())).build();
        return elasticsearchTemplate.queryForList(searchQuery, IntoMessage.class);
    }
    /**
      * 描述: 爬取百科资源
        * @param keyWord :
      * @return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     **/
    public List<Map<String, String>> getNetSource(String keyWord) {
        log.info("网络获取关键字为:{}",keyWord);
        if (StringUtils.isEmpty(keyWord)) {
            throw new ChatException(ExceptionEnum.KET_WORD_IS_NULL);
        }
        List<Map<String, String>> result = null;
        //返回的html页面
        String s = HttpsUtil.httpsGet(netSource.getBaiDuBaiKe() + "/item/" + keyWord);
        if (StringUtils.isEmpty(s)){
            return null;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                if (StringUtils.isNotEmpty(line) && line.contains("description")) {
                    String[] split = line.split("\"");
                    if (0 < split.length) {
                        int index = 0;
                        for (String param : split) {
                            //这里通过content来判断是为了防止输入英文的时候的大小写问题
                            if (param.equals(" content=")) {
                                result = new ArrayList<Map<String, String>>();
                                Map<String, String> res = new HashMap<>();
                                res.put(keyWord, split[++index]);
                                result.add(res);
                                return result;
                            }
                            index++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            log.error("关键字" + keyWord + "百科数据解析异常{}", e);
            throw new ChatException(ExceptionEnum.ANALYZE_ERROR);
        }
        return null;
    }
    /**
      * 描述: 查询信息
        * @param keyWord : 关键字
      * @return java.util.List<com.chat.search.pojo.IntoMessage>
     **/
    public  List<IntoMessage> searchMessage(String keyWord) {
        if (StringUtils.isEmpty(keyWord)){
            List<IntoMessage> intoMessageList = new ArrayList<>();
            IntoMessage intoMessage = new IntoMessage();
            log.info("关键字为空");
            intoMessage.setAll("关键字为空");
            intoMessageList.add(intoMessage);
            return intoMessageList;
        }
        List<IntoMessage> intoMessageList = new ArrayList<>();
        try {
            SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("keyWord", keyWord)).build();
            intoMessageList = elasticsearchTemplate.queryForList(searchQuery, IntoMessage.class);
            //如果es获取数据为空 那么获取网络资源
            if (CollectionUtils.isEmpty(intoMessageList)){
                List<Map<String, String>> netSource = getNetSource(keyWord);
                IntoMessage intoMessage = new IntoMessage();
                //这里重新初始化是因为经过es返回的结果不能执行add操作
                intoMessageList = new ArrayList<>();
                //判断是否为空
                if(CollectionUtils.isEmpty(netSource)){

                    log.info("关键字" + keyWord + "查询信息为空");
                    intoMessage.setAll("关键字:<<"+keyWord+">>查询信息为空");
                    intoMessageList.add(intoMessage);
                    return intoMessageList;
                }
                //封装数据
                Map<String, String> stringStringMap = netSource.get(NumConstant.NUM_0);
                intoMessage.setId(personalRedisUtil.incr(redisConfig.getEsNetId(),NumConstant.NUM_1));
                intoMessage.setKeyWord(keyWord);
                intoMessage.setAll(stringStringMap.get(keyWord));
                intoMessageList.add(intoMessage);
                intoMessageRepository.save(intoMessage);
                //将消息推送到mq
                sendMsgToMq(stringStringMap.get(keyWord));
            }
        }catch (Exception e){
            log.error("获取信息异常{}",e);
        }finally {
            //修改数据库的信息(先修改是为了防止发生死循环,对于那些没有结果的词语
            SearchAnalyze searchAnalyze = new SearchAnalyze();
            searchAnalyze.setKeyWord(keyWord);
            if (!CollectionUtils.isEmpty(intoMessageList)){
                searchAnalyze.setMeans(intoMessageList.get(NumConstant.NUM_0).getAll());
            }
            //修改1的操作换到获取关键字的时候执行
//            searchAnalyze.setGetNetsource(NumConstant.NUM_1);
            //异步修改数据
            ThreadUtil.excute(() ->searchAnalyzeClient.updateKeyWordMeans(searchAnalyze));
        }

        return intoMessageList;
    }
    public void sendMsgToMq(String msg){
        //将消息推送到mq
        rabbitTemplate.convertAndSend(searchFanoutExchange,"", msg);
    }

    public void testFeign(){
        List<SearchAnalyze> searchAnalyzeList = new ArrayList<>();
        SearchAnalyze searchAnalyze = new SearchAnalyze();
        searchAnalyze.setKeyWord("苹果");
        searchAnalyzeList.add(searchAnalyze);
        searchAnalyzeClient.addSearchAnalyzeKeyWord(searchAnalyzeList);
    }

}
