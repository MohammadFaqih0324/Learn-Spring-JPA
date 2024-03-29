package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.model.request.save.MajorSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.MajorUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MajorService {
    @Autowired
    private MajorRepository repository;

    public GeneralResponse<Object> save(MajorSaveRequest request){
        try {
            MajorEntity major = new MajorEntity(request.getName(), request.getIsActived());
            repository.save(major);
            return new GeneralResponse<>(200, "Success", "Success save major", major);
        }catch (Exception e){
            System.out.println("failed save major with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<MajorEntity> getAll(){
        List<MajorEntity> datas = new ArrayList<>();
        try {
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by id with error : " + e.getMessage());
        }
        return datas;
    }

    public MajorEntity getById(Long id){
        MajorEntity data = new MajorEntity();
        try{
            Optional<MajorEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public MajorEntity getByName(String name){
        MajorEntity data = new MajorEntity();
        try{
            Optional<MajorEntity> optional = repository.findByName(name);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by name with error : " + e.getMessage());
        }
        return data;
    }

    public GeneralResponse<Object> update(MajorUpdateRequest request){
        try {
            MajorEntity major = this.getById(request.getId());
            if (major.getId() != null){
                major = new MajorEntity(major, request.getUpdateBy(), request.getName(), request.getIsActived());
                repository.save(major);
                return new GeneralResponse<>(200, "Success", "Success update major", major);
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by name with error : " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
        return new GeneralResponse<>(100, "Failed", "Failed update major, major with id : " + request.getId() + " is not found", null);
    }

    public MajorEntity delete(Long id){
        MajorEntity data = new MajorEntity();
        try {
            MajorEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data major, id major " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data MajorEntity by name with error : " + e);
        }
        return data;
    }
}