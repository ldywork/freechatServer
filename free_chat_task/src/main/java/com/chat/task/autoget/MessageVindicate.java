package com.chat.task.autoget;

import com.chat.task.client.TaskAnalyzeClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: Parent
 * @Package: com.chat.task.autoget
 * @ClassName: MessageVindicate
 * @Description: java类作用描述
 * @Author: ldy
 * @CreateDate: 2020/6/14 20:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/14 20:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
@Configuration
@EnableScheduling
@Slf4j
public class MessageVindicate {
    @Autowired
    private TaskAnalyzeClient taskAnalyzeClient;

    @Scheduled(fixedRate=1000*60*60*5)
    private void configureTasks() {
//        log.info("数据维护任务启动,修改因系统问题产生的查询状态为1但是字面意思为空的数据");
        taskAnalyzeClient.updateFlag();
//        taskAnalyzeClient.getOneKeyWord("      ");
//        taskAnalyzeClient.updateKeyWordMeans(null);
    }
}
