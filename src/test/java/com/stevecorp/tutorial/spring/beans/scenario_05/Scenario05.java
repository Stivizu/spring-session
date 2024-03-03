package com.stevecorp.tutorial.spring.beans.scenario_05;

import com.stevecorp.tutorial.spring.beans.scenario_05.service.DependentJavaService;
import com.stevecorp.tutorial.spring.beans.scenario_05.service.JavaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario05 {

    @Autowired
    private ApplicationContext context;

    @Test
    void smartInterceptionBehaviour() {
        final JavaService javaService1 = context.getBean(JavaService.class);
        log.info("{}", javaService1);

        final DependentJavaService dependentJavaService = context.getBean(DependentJavaService.class);
        final JavaService javaService2 = dependentJavaService.getJavaService();
        log.info("{}", javaService2);
        dependentJavaService.sayHello();

        /*
            In this scenario we create a bean for the java service, and another bean that needs an instance of this java service as well.
             One might assume that the configuration class would create two different instances of the java service, but instead Spring only creates it once!
         */
    }

}
