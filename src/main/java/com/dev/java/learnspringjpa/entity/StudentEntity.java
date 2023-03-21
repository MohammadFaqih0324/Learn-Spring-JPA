package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "STUDENT")
public class StudentEntity extends BaseEntity {
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "MAJOR")
    private MajorEntity major;

    @OneToOne
    @JoinColumn(name = "ADDRESS")
    private AddressEntity address;

    @ManyToMany
    @JoinTable(name = "enrollment",
            joinColumns = @JoinColumn(name = "student"),
            inverseJoinColumns = @JoinColumn(name = "course"))
    private List<CourseEntity> courses;
}