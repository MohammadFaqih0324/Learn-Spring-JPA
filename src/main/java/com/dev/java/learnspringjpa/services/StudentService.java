package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public StudentEntity save(String name, int age, MajorEntity majorEntity, AddressEntity address, List<CourseEntity> courses){
        StudentEntity student = new StudentEntity(name, age, majorEntity, address, courses);
        StudentEntity response = repository.save(student);
        return response;
    }
}