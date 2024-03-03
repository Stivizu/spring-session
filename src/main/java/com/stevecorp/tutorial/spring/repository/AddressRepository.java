package com.stevecorp.tutorial.spring.repository;

import com.stevecorp.tutorial.spring.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    @Override
    List<Address> findAll();

}
