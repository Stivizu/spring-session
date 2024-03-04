package com.stevecorp.tutorial.spring.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentNotFoundException extends RuntimeException {

    private long id;

}
