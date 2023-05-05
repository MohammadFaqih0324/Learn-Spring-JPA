package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.model.StudentSaveRequest;
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
    public List<StudentEntity> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody StudentSaveRequest request){
        studentService.save(request.getName(), request.getAge(),
                request.getMajor(), request.getAddress(), request.getCourse());
    }
}