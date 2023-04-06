package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository repository;

    public LessonEntity save(String name, Boolean isActived, MajorEntity major){
        LessonEntity lesson = new LessonEntity(name, isActived, major);
        LessonEntity response = repository.save(lesson);
        return response;
    }

    public List<LessonEntity> getAll(){
        List<LessonEntity> datas;
        datas = repository.findAll();
        return datas;
    }

    public LessonEntity getById(Long id){
        LessonEntity data = new LessonEntity();
        try{
            Optional<LessonEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data LessonEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public List<LessonEntity> getByName(String name){
        List<LessonEntity> data = new ArrayList<>();
        try{
           data = repository.findByName(name);
        }catch (Exception e){
            System.out.println("failed get data LessonEntity by name with error : " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
}