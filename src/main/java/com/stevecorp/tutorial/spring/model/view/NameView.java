package com.stevecorp.tutorial.spring.model.view;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NameView {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
