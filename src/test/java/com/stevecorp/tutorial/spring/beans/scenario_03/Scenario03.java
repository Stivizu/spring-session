package com.stevecorp.tutorial.spring.beans.scenario_03;

import com.stevecorp.tutorial.spring.beans.scenario_03.service.SpringService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario03 {

    @Autowired
    private ApplicationContext context;

    @Test
    void gettingABeanOfTheSameTypeMultipleTimes() {
        final SpringService springService1 = context.getBean(SpringService.class);
        log.info("{}", springService1);

        final SpringService springService2 = context.getBean(SpringService.class);
        log.info("{}", springService2);

        /*
            Note that both beans are the same instance!
             This is because by default Spring beans are singletons.
             This behaviour can be modified, see scenario 10.
         */
    }

}
