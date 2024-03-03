package com.stevecorp.tutorial.spring.beans.scenario_07.configuration;

import com.stevecorp.tutorial.spring.beans.scenario_07.model.ConnectionProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:example-application.properties")
public class BeanConfiguration {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public ConnectionProperties connectionProperties() {
        return ConnectionProperties.builder()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

}
