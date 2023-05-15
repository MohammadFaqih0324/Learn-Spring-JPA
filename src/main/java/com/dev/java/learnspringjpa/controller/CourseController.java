package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.model.request.save.CourseSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.CourseUpdateRequest;
import com.dev.java.learnspringjpa.model.request.update.StudentUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get-all")
    public GeneralResponse<Object> getAll(){
        List<CourseEntity> datas = courseService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data course", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody CourseSaveRequest request){
        return courseService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        CourseEntity course = courseService.getById(id);
        if (course.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data by id course", course);
        }
        return new GeneralResponse<>(100, "Failed", "Course with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-name")
    public GeneralResponse<Object> getByName(@RequestParam String name){
        CourseEntity course = courseService.getByName(name);
        if (course.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data course", course);
        }
        return new GeneralResponse<>(100, "Failed", "Course with name " + name + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody CourseUpdateRequest request){
        return courseService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        CourseEntity course = courseService.delete(id);
        if (course.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data course", course);
        }
        return new GeneralResponse<>(100, "Failed", "Course with id " + id + " is not found!", null);
    }
}