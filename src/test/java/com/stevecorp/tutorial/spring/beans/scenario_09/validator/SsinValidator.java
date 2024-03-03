package com.stevecorp.tutorial.spring.beans.scenario_09.validator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SsinValidator {

    final String countryCode;

    public boolean isValid(final String ssin) {
        return switch (countryCode) {
            case "BE" -> ssin.length() == 11;
            case "NL" -> ssin.length() == 9;
            default -> throw new RuntimeException("Unsupported country!");
        };
    }

}
