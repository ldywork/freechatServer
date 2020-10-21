package com.chat.search.common.thread;

import com.chat.properties.ThreadConfig;
import com.chat.search.common.constants.NumConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.concurrent.*;

@Slf4j
//@EnableConfigurationProperties({ThreadConfig.class})
public class ThreadUtil {
//    @Autowired
//    private static ThreadConfig threadConfig;
    public static ExecutorService fixedPool = Executors.newFixedThreadPool(NumConstant.NUM_5);

    public static void excute (Runnable run){
        try {
            fixedPool.execute(run);
        }catch (Exception e){
            log.error("异步线程执行异常",e);
        }

    }

}
