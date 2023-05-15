package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.model.request.save.StudentSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.StudentUpdateRequest;
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
    public GeneralResponse<Object> getAll(){
        List<StudentEntity> datas = studentService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data student", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody StudentSaveRequest request){
            return studentService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        StudentEntity student = studentService.getById(id);
        if (student.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data student", student);
        }
        return new GeneralResponse<>(100, "Failed", "Student with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-name")
    public GeneralResponse<Object> getByName(@RequestParam String name){
        StudentEntity student = studentService.getByName(name);
        if (student.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data student", student);
        }
        return new GeneralResponse<>(100, "Failed", "Student with name " + name + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody StudentUpdateRequest request){
        return studentService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        StudentEntity student = studentService.delete(id);
        if (student.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data student", student);
        }
        return new GeneralResponse<>(100, "Failed", "Student with id " + id + " is not found!", null);
    }
}