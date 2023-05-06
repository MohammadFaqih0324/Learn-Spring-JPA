package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.model.request.StudentSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all")
    public GeneralResponse getAll(){
        List<StudentEntity> datas = studentService.getAll();
        return new GeneralResponse(200, "Success", "Success get data student", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody StudentSaveRequest request){
        GeneralResponse response = studentService.save(request);
        return response;
    }
}