package com.stevecorp.tutorial.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*
    Do note that we had to exclude the student from the @ToString, since this would lead to an infinite loop while printing.
 */
@ToString(exclude = "student")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String box;

    @NotBlank
    private String city;

    @NotBlank
    private String zip;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "student_id")
    private Student student;

}
