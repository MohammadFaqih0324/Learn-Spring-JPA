package com.dev.java.learnspringjpa.model;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import lombok.Data;

import java.util.List;

@Data
public class StudentSaveRequest {

    private String name;
    private int age;
    private MajorEntity major;
    private AddressEntity address;
    private List<CourseEntity> course;
}
