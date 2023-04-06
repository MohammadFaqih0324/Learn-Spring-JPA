package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "COURSE")
public class CourseEntity extends BaseEntity{
    private String name;
    private Boolean isActived;

//    @ManyToMany(mappedBy = "courses")
//    private List<StudentEntity> students;

    public CourseEntity() {
    }

    public CourseEntity(String name, Boolean isActived) {
        this.name = name;
        this.isActived = isActived;
    }
}