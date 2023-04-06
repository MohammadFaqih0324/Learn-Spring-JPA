package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public RoleEntity save(String name, Boolean isActived){
        RoleEntity role = new RoleEntity(name, isActived);
        RoleEntity response = repository.save(role);
        return response;
    }

    public List<RoleEntity> getAll(){
        List<RoleEntity> datas;
        datas = repository.findAll();
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
}