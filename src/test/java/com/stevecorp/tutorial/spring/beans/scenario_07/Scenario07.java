package com.stevecorp.tutorial.spring.beans.scenario_07;

import com.stevecorp.tutorial.spring.beans.scenario_07.model.ConnectionProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario07 {

    @Autowired
    private ApplicationContext context;

    @Test
    void propertiesFromAnExternalConfigurationFile() {
        final ConnectionProperties connectionProperties = context.getBean(ConnectionProperties.class);
        log.info(connectionProperties.toString());

        /*
            By default, Spring will add application.properties files from your resources folder into your application context.
             Sometimes we want to add properties from a different file. We can achieve this by using the @PropertySource annotation.
             Note that if you would remove this annotation, it will throw an exception as Spring would no longer be able to fill in the values where you added the @Value annotation.
         */

        /*
            Note that we are using application.properties files, while you could also use application.yaml files.
             Yaml files have a cleaner syntax with less repetition in your properties.
         */

        /*
            You can also supply default values in Springs @Value annotations.
             This can be achieved by adding a :{default_value} after the key.
             for example: ${db.password:admin}
         */
    }

}
