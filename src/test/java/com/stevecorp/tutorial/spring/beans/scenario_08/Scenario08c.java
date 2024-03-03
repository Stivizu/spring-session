package com.stevecorp.tutorial.spring.beans.scenario_08;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario08c {

    /*
        This scenario handles setter injection.
     */

    private ApplicationContext context;

    @Test
    void setterInjection() {
        log.info(context.getDisplayName());
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
