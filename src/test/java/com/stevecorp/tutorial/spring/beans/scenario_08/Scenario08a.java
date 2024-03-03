package com.stevecorp.tutorial.spring.beans.scenario_08;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario08a {

    /*
        This scenario handles field injection, which we've been using in all scenarios so far.
     */

    @Autowired
    private ApplicationContext context;

    @Test
    void fieldInjection() {
        log.info(context.getDisplayName());
    }

}
