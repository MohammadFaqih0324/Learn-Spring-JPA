package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.model.request.save.CourseSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.CourseUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public GeneralResponse<Object> save(CourseSaveRequest request){
        try {
            CourseEntity course = new CourseEntity(request.getName(), request.getIsActived());
            repository.save(course);
            return new GeneralResponse<>(200, "Success", "Success save course", course);
        }catch (Exception e){
            System.out.println("failed save major with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<CourseEntity> getAll(){
        List<CourseEntity> datas = new ArrayList<>();
        try{
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data CourseEntity by id with error : " + e.getMessage());
        }
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

    public GeneralResponse<Object> update(CourseUpdateRequest request){
        try {
            CourseEntity course = this.getById(request.getId());
            if (course.getId() != null){
                course = new CourseEntity(course, request.getUpdateBy(), request.getName(), request.getIsActived());
                repository.save(course);
                return new GeneralResponse<>(200, "Success", "Success update course", course);
            }
        }catch (Exception e){
            System.out.println("failed get data CourseEntity by name with error : " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
        return new GeneralResponse<>(100, "Failed", "Failed update course, course with id : " + request.getId() + " is not found", null);
    }

    public CourseEntity delete(Long id){
        CourseEntity data = new CourseEntity();
        try {
            CourseEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data course, id course " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data CourseEntity by name with error : " + e);
        }
        return data;
    }
}