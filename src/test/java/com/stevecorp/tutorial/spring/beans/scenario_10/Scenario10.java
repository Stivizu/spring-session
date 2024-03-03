package com.stevecorp.tutorial.spring.beans.scenario_10;

import com.stevecorp.tutorial.spring.beans.scenario_10.service.SpringService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario10 {

    private final ApplicationContext context;

    public Scenario10(ApplicationContext context) {
        this.context = context;
    }

    @Test
    void beanScopes() {
        final SpringService springService1 = context.getBean(SpringService.class);
        log.info("{}", springService1);

        final SpringService springService2 = context.getBean(SpringService.class);
        log.info("{}", springService2);

        final SpringService springService3 = context.getBean(SpringService.class);
        log.info("{}", springService3);
    }
}
