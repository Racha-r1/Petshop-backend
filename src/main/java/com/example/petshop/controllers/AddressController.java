package com.example.petshop.controllers;

import com.example.petshop.models.Address;
import com.example.petshop.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAddressesOfUser(@RequestParam(name = "user_email") String user_email){
        return addressRepository.getAddressesOfUser(user_email);
    }

    @PostMapping
    public Address addAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @DeleteMapping("{id}")
    public void deleteAddressById(@PathVariable long id){
        addressRepository.deleteById(id);
    }
}
