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
    @ManyToOne
    @JoinColumn(name = "MAJOR")
    private MajorEntity major;

    public LessonEntity(){
    }

    public LessonEntity(String name, Boolean isActived, MajorEntity major) {
        this.name = name;
        this.isActived = isActived;
        this.major = major;
    }

    public String toString(){
        return "id = " + this.getId() + "  name = " + this.getName();
    }
}