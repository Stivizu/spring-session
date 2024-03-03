package com.stevecorp.tutorial.spring.beans.scenario_09;

import com.stevecorp.tutorial.spring.beans.scenario_09.validator.SsinValidator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Scenario09 {

    private final SsinValidator ssinValidator;

    /*
        Getting a named bean through constructor injection can be done by using the @Qualifier annotation.
         Note that this is case-sensitive!
     */

    public Scenario09(@Qualifier("ssinValidatorBe") SsinValidator ssinValidator) {
        this.ssinValidator = ssinValidator;
    }

    @Test
    void namedBeans() {
        final String ssin9Characters = "123456789";
        final boolean ssin9IsValid = ssinValidator.isValid(ssin9Characters);
        log.info("SSIN 9 is valid: {}", ssin9IsValid);

        final String ssin11Characters = "12345678910";
        final boolean ssin11IsValid = ssinValidator.isValid(ssin11Characters);
        log.info("SSIN 11 is valid: {}", ssin11IsValid);
    }

}
