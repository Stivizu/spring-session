package com.stevecorp.tutorial.spring.beans.scenario_08;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario08b {

    /*
        This scenario handles constructor injection.
         Note that this the suggested way of working in Spring, as mentioned by the Spring developers themselves.
         If you only have one constructor, you can even omit the @Autowired annotation!
     */

    private final ApplicationContext context;

    public Scenario08b(final ApplicationContext context) {
        this.context = context;
    }

    @Test
    void constructorInjection() {
        log.info(context.getDisplayName());
    }

}
