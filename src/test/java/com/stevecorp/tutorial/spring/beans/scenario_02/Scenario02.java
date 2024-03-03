package com.stevecorp.tutorial.spring.beans.scenario_02;

import com.stevecorp.tutorial.spring.beans.scenario_02.service.JavaService;
import com.stevecorp.tutorial.spring.beans.scenario_02.service.SpringService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootTest
public class Scenario02 {

    @Autowired
    private ApplicationContext context;

    @Test
    void addABeanToTheSpringContainer() {
        final String[] beanNames = context.getBeanDefinitionNames();
        log.info("\n\n{}\n", String.join("\n", beanNames));

        final boolean hasSpringService = Arrays.stream(beanNames)
                .anyMatch(beanName -> beanName.equalsIgnoreCase(SpringService.class.getSimpleName()));
        log.info("Contains SpringService: {}", hasSpringService);

        final boolean hasJavaService = Arrays.stream(beanNames)
                .anyMatch(beanName -> beanName.equalsIgnoreCase(JavaService.class.getSimpleName()));
        log.info("Contains JavaService: {}", hasJavaService);

        final SpringService springService = context.getBean(SpringService.class);
        springService.sayHello();

        try {
            final JavaService javaService = context.getBean(JavaService.class);
            javaService.sayHello();
        } catch (Exception e) {
            log.error("Exception while trying to retrieve bean of type {}", JavaService.class.getSimpleName(), e);
        }

        /*
            The service that we annotated with Spring's @Service annotation, was automatically added to the application context.
             The other service was not.
             When trying to retrieve a bean from the application context that does not exist, an exception will be thrown.
         */

        /*
            We could have also tried to autowire both these Services.
             But then the application would have been unable to start, since it wouldn't be able to find the JavaService bean.
             Your compiler would have also warned you about this.
         */

    }

}