package com.stevecorp.tutorial.spring.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private Name name;
    private LocalDate dateOfBirth;
    private List<Address> addresses;

}
