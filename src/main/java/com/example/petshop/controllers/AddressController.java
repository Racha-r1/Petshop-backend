package com.example.petshop.controllers;

import com.example.petshop.models.Address;
import com.example.petshop.models.Category;
import com.example.petshop.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{id}")
    public Optional<Address> getAddressById(@PathVariable long id){
        return addressRepository.findById(id);
    }

    @PostMapping
    public Address addAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @PutMapping("{id}")
    public Address updateAddress(@PathVariable long id, @RequestBody Address addressData){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()){
            Address updatedAddress = address.get();
            updatedAddress.setNummer(addressData.getNummer());
            updatedAddress.setStad(addressData.getStad());
            updatedAddress.setPostcode(addressData.getPostcode());
            updatedAddress.setStraat(addressData.getStraat());
            return addressRepository.save(updatedAddress);
        }
        // if nothing is updated just return the requestbody data
        return addressData;
    }

    @DeleteMapping("{id}")
    public void deleteAddressById(@PathVariable long id){
        addressRepository.deleteById(id);
    }
}
