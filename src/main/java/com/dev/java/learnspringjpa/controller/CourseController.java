package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.model.request.CourseSaveRequest;
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
    public GeneralResponse getAll(){
        List<CourseEntity> datas = courseService.getAll();
        return new GeneralResponse(200, "Success", "Success get data course", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody CourseSaveRequest request){
        GeneralResponse response = courseService.save(request);
        return response;
    }

}