package com.stevecorp.tutorial.spring.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Long id;
    private AddressType addressType;
    private String street;
    private String number;
    private String box;
    private String city;
    private String zip;

}
