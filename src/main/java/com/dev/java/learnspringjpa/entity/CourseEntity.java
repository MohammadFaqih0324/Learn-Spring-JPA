package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity(name = "COURSE")
public class CourseEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students;
}