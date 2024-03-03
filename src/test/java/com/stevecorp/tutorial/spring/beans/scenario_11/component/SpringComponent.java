package com.stevecorp.tutorial.spring.beans.scenario_11.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringComponent {

    public SpringComponent() {
        log.info("\n\n");
        log.info("--> Calling SpringComponent Constructor!\n\n");
    }

    public void sayHello() {
        log.info("Hello!\n\n");
    }

}
