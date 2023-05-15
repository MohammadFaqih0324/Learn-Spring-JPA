package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.model.request.save.AddressSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.AddressUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public GeneralResponse<Object> save(AddressSaveRequest request){
        try {
            AddressEntity address = new AddressEntity(request.getAddress());
            repository.save(address);
            return new GeneralResponse<>(200, "Success", "Success save address", address);
        }catch (Exception e){
            System.out.println("failed save address with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<AddressEntity> getAll(){
        List<AddressEntity> datas = null;
        try {
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data AddressEntity by id with error : " + e.getMessage());
        }
        return datas;
    }

    public AddressEntity getById(Long id){
        AddressEntity data = new AddressEntity();
        try{
            Optional<AddressEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data AddressEntity by id with error : " + e.getMessage());
        }
        return data;
    }
    public AddressEntity getByAddress(String address){
        AddressEntity data = new AddressEntity();
        try{
            Optional<AddressEntity> optional = repository.findByAddress(address);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data AddressEntity by address with error : " + e.getMessage());
        }
        return data;
    }

    public GeneralResponse<Object> update(AddressUpdateRequest request){
        try {
            AddressEntity address = this.getById(request.getId());
            if (address.getId() != null) {
                address = new AddressEntity(address, request.getUpdateBy(), request.getAddress());
                repository.save(address);
                return new GeneralResponse<>(200, "Success", "Success update address", address);
            }
        }catch (Exception e) {
            System.out.println("failed update address with error : " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
        return new GeneralResponse<>(100, "Failed", "Failed update address, address with id : " + request.getId() + " is not found", null);
    }

    public AddressEntity delete(Long id){
        AddressEntity data = new AddressEntity();
        try {
            AddressEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data address, id address " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data AddressEntity by name with error : " + e);
        }
        return data;
    }
}