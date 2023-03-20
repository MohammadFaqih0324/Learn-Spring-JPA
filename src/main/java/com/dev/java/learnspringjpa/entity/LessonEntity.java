package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "LESSON")
public class LessonEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    @ManyToOne
    @JoinColumn(name = "MAJOR")
    private MajorEntity major;
}