package com.stevecorp.tutorial.spring.beans.scenario_04;

import com.stevecorp.tutorial.spring.beans.scenario_04.configuration.BeanConfiguration;
import com.stevecorp.tutorial.spring.beans.scenario_04.service.JavaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario04 {

    @Autowired
    private ApplicationContext context;

    @Test
    void definingABeanThroughAConfigurationClass() {
        final BeanConfiguration beanConfiguration = context.getBean(BeanConfiguration.class);
        final JavaService javaService1 = beanConfiguration.javaService();
        log.info("{}", javaService1);
        javaService1.sayHello();

        final JavaService javaService2 = context.getBean(JavaService.class);
        log.info("{}", javaService2);
        javaService2.sayHello();

        /*
            We defined a bean (annotated with the @Bean annotation) inside a class annotated with Spring's @Configuration annotation.
             Spring will automatically add these beans (including the configuration class bean) to the application context.
         */

        /*
            Note that when we ask for the service bean through the configuration bean, it is the same instance as when we ask for the bean directly from the application context.
         */
    }

}
