package com.stevecorp.tutorial.spring.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Name {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
