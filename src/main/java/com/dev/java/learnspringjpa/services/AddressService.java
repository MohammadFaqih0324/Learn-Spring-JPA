package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public AddressEntity save(String address){
        AddressEntity addressEntity = new AddressEntity(address);
        AddressEntity response =  repository.save(addressEntity);
        return response;
    }
}