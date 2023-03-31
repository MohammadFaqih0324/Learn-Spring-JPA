package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "STUDENT")
public class StudentEntity extends BaseEntity {
    private String name;
    private int age;

    public StudentEntity(){
    }

    public StudentEntity(String name, int age, MajorEntity major, AddressEntity address, List<CourseEntity> courses) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.address = address;
        this.courses = courses;
    }
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