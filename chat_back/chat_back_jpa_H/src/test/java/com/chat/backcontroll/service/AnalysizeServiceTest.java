package com.chat.backcontroll.service;

import com.chat.backcontroll.analysizeinterface.AnalysizeCURDRepository;
import com.chat.backcontroll.analysizeinterface.AnalysizeRepository;
import com.chat.backcontroll.hiberentity.HiberSearchAnalyze;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AnalysizeServiceTest {
    @Autowired
    private AnalysizeRepository analysizeRepository;
    @Autowired
    private AnalysizeCURDRepository analysizeCURDRepository;

    /**
     * 描述: 普通根据api查询
     *
     * @return void
     **/
    @Test
    public void test1() {
        System.out.println("dsafsdfas");
        Optional<HiberSearchAnalyze> byId = analysizeRepository.findById(1l);
        System.out.println(byId);

    }

    /**
     * 描述: 根据特定的方法名称来执行查询
     *
     * @return void
     **/
    @Test
    public void test2() {
        List<HiberSearchAnalyze> keyWord = analysizeRepository.findByKeyWord("苹果");
        System.out.println(keyWord);
    }

    /**
     * 描述: 模糊查询
     * 其中like和containing的区别是like里边没有添加默认的百分号,需要字段自己来添加,containing默认添加,感觉like这样做更加灵活.
     *
     * @return void
     **/
    @Test
    public void test3() {
        List<HiberSearchAnalyze> keyWord = analysizeRepository.findByKeyWordLike("%苹果%");
        System.out.println(keyWord);
    }

    /**
     * 描述: 通过@query方式手写sql来实现查询,注意查询的语句中的form后边跟的不是表名,而是映射实体类
     *
     * @return void
     **/
    @Test
    public void test4() {
        List<HiberSearchAnalyze> keyWord = analysizeRepository.findBySql(1L);
        System.out.println(keyWord);
    }

    /**
     * 描述: 模糊查询  注意:模糊搜索的时候,where条件后边字段可以是映射类的字段也可以是数据库表中的字段,
     * 在创建查询的sql的时候,首先按照属性类的字段去匹配如果没有那么就按照
     * 代码里边写的字段来生成sql
     *
     * @return void
     **/
    @Test
    public void test5() {
        List<HiberSearchAnalyze> keyWord = analysizeRepository.findBySqlUseKey("苹果");
        System.out.println(keyWord);
    }

    /**
     * 描述:执行原生的sql
     *
     * @return void
     **/
    @Test
    public void test6() {
        List<HiberSearchAnalyze> keyWord = analysizeRepository.findBySqlUseKeyNative("苹果");
        System.out.println(keyWord);
    }

    /**
     * 描述: api方式来修改数据
     * @return void
     **/
    @Test
    public void test7() {
        Optional<HiberSearchAnalyze> byId = analysizeRepository.findById(1L);
        byId.get().setGetNetsource(0);
        analysizeRepository.save(byId.get());
        System.out.println(byId.get());
    }

}
