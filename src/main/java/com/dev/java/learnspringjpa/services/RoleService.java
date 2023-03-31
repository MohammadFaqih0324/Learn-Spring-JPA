package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public RoleEntity save(String name, Boolean isActived){
        RoleEntity role = new RoleEntity(name, isActived);
        RoleEntity response = repository.save(role);
        return response;
    }
}
