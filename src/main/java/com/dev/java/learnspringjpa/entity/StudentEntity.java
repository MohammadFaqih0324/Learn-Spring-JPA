package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
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

    public StudentEntity(){
    }

    public StudentEntity(String name, int age, MajorEntity major, AddressEntity address, List<CourseEntity> courses) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.address = address;
        this.courses = courses;
    }

    public StudentEntity(StudentEntity studentEntity, String updateBy, String name, int age, MajorEntity major, AddressEntity address, List<CourseEntity> courses) {
        super.setId(studentEntity.getId());
        super.setCreatedDate(studentEntity.getCreatedDate());
        super.setCreatedBy(studentEntity.getCreatedBy());
        super.setUpdatedBy(updateBy);
        this.name = name;
        this.age = age;
        this.major = major;
        this.address = address;
        this.courses = courses;
    }

    public String toString(){
        return "id = " + this.getId() + " name = " + this.getName();
    }
}