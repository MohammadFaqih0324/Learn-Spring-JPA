package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.model.request.AddressSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/get-all")
    public GeneralResponse getAll(){
        List<AddressEntity> datas = addressService.getAll();
        return new GeneralResponse(200, "Success", "Success get data address", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody AddressSaveRequest request){
        GeneralResponse response = addressService.save(request);
        return response;
    }
}
