package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.model.request.save.AddressSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.AddressUpdateRequest;
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
    public GeneralResponse<Object> getAll(){
        List<AddressEntity> datas = addressService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data address", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody AddressSaveRequest request){
        return addressService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        AddressEntity address = addressService.getById(id);
        if (address.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data by id address", address);
        }
        return new GeneralResponse<>(100, "Failed", "Address with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-address")
    public GeneralResponse<Object> getByAddress(@RequestParam String address){
        AddressEntity byAddress = addressService.getByAddress(address);
        if (byAddress.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data address", byAddress);
        }
        return new GeneralResponse<>(100, "Failed", "Address with name " + address + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody AddressUpdateRequest request){
        return addressService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        AddressEntity address = addressService.delete(id);
        if (address.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data address", address);
        }
        return new GeneralResponse<>(100, "Failed", "Address with id " + id + " is not found!", null);
    }
}
