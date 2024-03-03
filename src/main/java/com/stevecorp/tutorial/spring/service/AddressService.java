package com.stevecorp.tutorial.spring.service;

import com.stevecorp.tutorial.spring.model.Address;
import com.stevecorp.tutorial.spring.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

}
