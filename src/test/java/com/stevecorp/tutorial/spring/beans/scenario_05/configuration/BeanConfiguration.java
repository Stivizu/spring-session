package com.stevecorp.tutorial.spring.beans.scenario_05.configuration;

import com.stevecorp.tutorial.spring.beans.scenario_05.service.DependentJavaService;
import com.stevecorp.tutorial.spring.beans.scenario_05.service.JavaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    public JavaService javaService() {
        log.info("---> Creating a new JavaService instance!");
        return new JavaService();
    }

    @Bean
    public DependentJavaService dependentJavaService() {
        return new DependentJavaService(javaService());
    }

}
