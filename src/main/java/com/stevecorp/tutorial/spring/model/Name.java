package com.stevecorp.tutorial.spring.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Name {

    private String firstName;
    private String lastName;

}
