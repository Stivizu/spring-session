package com.stevecorp.tutorial.spring.model.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class NameEntity {

    private String firstName;

    private String lastName;

}
