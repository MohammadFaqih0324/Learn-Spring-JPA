package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.model.request.RoleSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public GeneralResponse<Object> save(RoleSaveRequest request){
        try {
            RoleEntity role = new RoleEntity(request.getName(), request.getIsActived());
            repository.save(role);
            return new GeneralResponse<>(200, "Success", "Success save role", role);
        }catch (Exception e){
            System.out.println("failed save role with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<RoleEntity> getAll(){
        List<RoleEntity> datas = null;
        try {
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data RoleEntity by id with error : " + e.getMessage());
        }
        return datas;
    }

    public RoleEntity getById(Long id){
        RoleEntity data = new RoleEntity();
        try{
            Optional<RoleEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public RoleEntity getByName(String name){
        RoleEntity data = new RoleEntity();
        try{
            Optional<RoleEntity> optional = repository.findByName(name);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public RoleEntity update(Long id, RoleEntity roleEntity){
        RoleEntity data = new RoleEntity();
        try {
            RoleEntity dataFromDb = this.getById(id);
            if (dataFromDb.getId() != null){
                dataFromDb.setUpdatedBy(roleEntity.getUpdatedBy());
                dataFromDb.setName(roleEntity.getName());
                dataFromDb.setIsActived(roleEntity.getIsActived());
                data = repository.save(dataFromDb);
            }
        }catch (Exception e){
            System.out.println("failed get data RoleEntity by name with error : " + e);
        }
        return data;
    }

    public RoleEntity delete(Long id){
        RoleEntity data = new RoleEntity();
        try {
            RoleEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data role, id role " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data RoleEntity by name with error : " + e);
        }
        return data;
    }
}