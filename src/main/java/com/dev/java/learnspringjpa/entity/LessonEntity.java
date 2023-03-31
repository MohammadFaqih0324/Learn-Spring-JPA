package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "LESSON")
public class LessonEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    public LessonEntity(){
    }

    public LessonEntity(String name, Boolean isActived, MajorEntity major) {
        this.name = name;
        this.isActived = isActived;
        this.major = major;
    }

    @ManyToOne
    @JoinColumn(name = "MAJOR")
    private MajorEntity major;
}