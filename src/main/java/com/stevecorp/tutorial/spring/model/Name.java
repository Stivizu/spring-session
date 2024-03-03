package com.stevecorp.tutorial.spring.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Name {

    private String firstName;

    private String lastName;

}
