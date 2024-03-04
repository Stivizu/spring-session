package com.stevecorp.tutorial.spring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private NameEntity name;

    private LocalDate dateOfBirth;

    private boolean active;

    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<AddressEntity> addresses;

}
