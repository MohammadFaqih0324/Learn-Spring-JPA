package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService {
    @Autowired
    private MajorRepository repository;

    public MajorEntity save(String name, Boolean isActived){
        MajorEntity major = new MajorEntity(name, isActived);
        MajorEntity response = repository.save(major);
        return response;
    }
}