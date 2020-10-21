package com.chat.backcontroll;

import com.chat.backcontroll.analysizeinterface.AnalysizeRepository;
import com.chat.backcontroll.hiberentity.HiberSearchAnalyze;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnalysizeServiceTest.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@ContextConfiguration
public class AnalysizeServiceTest {
    @Autowired
    private AnalysizeRepository analysizeRepository;
    @Test
    public void test1(){
        System.out.println("dsafsdfas");
        Optional<HiberSearchAnalyze> byId = analysizeRepository.findById(1l);
        System.out.println(byId);

    }
}
