package com.stevecorp.tutorial.spring.model.view;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentView {

    private Long id;

    private NameView name;

    @Past
    @NotNull
    private LocalDate dateOfBirth;

    private List<AddressView> addresses;

}
