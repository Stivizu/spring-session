package com.stevecorp.tutorial.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @Past
    @NotNull
    private LocalDate dateOfBirth;

    /*
        Note that we need to ignore this field during JSON (de)serialization, otherwise the client could un-delete students.
         A proper fix for this issue comes in the next branch.
     */
    @JsonIgnore
    private boolean active = true;

    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Address> addresses;

}
