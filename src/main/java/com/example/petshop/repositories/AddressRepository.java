package com.example.petshop.repositories;

import com.example.petshop.models.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    @Query(value = "SELECT * FROM addresses WHERE user_email= :user_email", nativeQuery = true)
    List<Address> getAddressesOfUser(String user_email);
}
