package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public CourseEntity save(String name, Boolean isActived) {
        CourseEntity courseEntity = new CourseEntity(name, isActived);
        CourseEntity response = repository.save(courseEntity);
        return response;
    }

    public List<CourseEntity> getAll(){
        List<CourseEntity> datas;
        datas = repository.findAll();
        return datas;
    }

    public CourseEntity getById(Long id){
        CourseEntity data = new CourseEntity();
        try{
            Optional<CourseEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data CourseEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public CourseEntity getByName(String name){
        CourseEntity data = new CourseEntity();
        try{
            Optional<CourseEntity> optional = repository.findByName(name);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data CourseEntity by name with error : " + e.getMessage());
        }
        return data;
    }
}