package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.entity.UserEntity;
import com.dev.java.learnspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public UserEntity save(String username, String password, Boolean isActived, List<RoleEntity> roles){
        UserEntity user = new UserEntity(username, password, isActived, roles);
        UserEntity response = repository.save(user);
        return response;
    }
}