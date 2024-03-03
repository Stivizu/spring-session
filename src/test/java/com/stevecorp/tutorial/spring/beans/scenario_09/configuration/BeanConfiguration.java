package com.stevecorp.tutorial.spring.beans.scenario_09.configuration;

import com.stevecorp.tutorial.spring.beans.scenario_09.validator.SsinValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    /*
        By default, Spring will use the name of the method as name of the bean.
         You can customize the name by specifying the name argument in the @Bean annotation.
     */

    /*
        In this scenario, you could get a bean from the application context through name, or also by class name.
         However, since there are now two beans of the same type, Spring will not know which bean you want and throw an exception.
         This can easily be resolved by marking one of the beans with the @Primary annotation. In that case Spring will by default return that bean.
     */

    @Bean(name = "ssinValidatorBe")
    public SsinValidator ssinValidatorBe() {
        return new SsinValidator("BE");
    }

    @Bean
    public SsinValidator ssinValidatorNl() {
        return new SsinValidator("NL");
    }

}
