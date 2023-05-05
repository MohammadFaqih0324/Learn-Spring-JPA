package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.model.AddressSaveRequest;
import com.dev.java.learnspringjpa.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/get-all")
    public List<AddressEntity> getAll(){
        return addressService.getAll();
    }

    @PostMapping("/save")
    public void save(AddressSaveRequest request){
        addressService.save(request.getAddress());
    }
}
