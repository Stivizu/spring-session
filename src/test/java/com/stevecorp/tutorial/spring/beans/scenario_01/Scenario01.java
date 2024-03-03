package com.stevecorp.tutorial.spring.beans.scenario_01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario01 {

    // The Lombok @Slf4j annotation is simply a replacement for the next line:
    //    private static final Logger LOGGER = LoggerFactory.getLogger(Scenario01.class);

    @Autowired
    private ApplicationContext context;

    @Test
    void listAllBeansInsideTheSpringContainer() {
        final String[] beanNames = context.getBeanDefinitionNames();
        log.info("\n\n{}", String.join("\n", beanNames));
    }

}