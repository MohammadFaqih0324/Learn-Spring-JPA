package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;

@Entity(name = "MAJOR")
public class MajorEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    @OneToMany(mappedBy = "major")
    private Set<LessonEntity> lesson;

    @OneToMany(mappedBy = "major")
    private List<StudentEntity> student;
}