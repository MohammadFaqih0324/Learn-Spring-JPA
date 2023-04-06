package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.entity.UserEntity;
import com.dev.java.learnspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserEntity save(String username, String password, Boolean isActived, List<RoleEntity> roles){
        UserEntity user = new UserEntity(username, password, isActived, roles);
        UserEntity response = repository.save(user);
        return response;
    }

    public List<UserEntity> getAll(){
        List<UserEntity> datas;
        datas = repository.findAll();
        return datas;
    }

    public UserEntity getById(Long id){
        UserEntity data = new UserEntity();
        try{
            Optional<UserEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public UserEntity getByUserName(String userName){
        UserEntity data = new UserEntity();
        try{
            Optional<UserEntity> optional = repository.findByUserName(userName);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by username with error : " + e.getMessage());
        }
        return data;
    }
}