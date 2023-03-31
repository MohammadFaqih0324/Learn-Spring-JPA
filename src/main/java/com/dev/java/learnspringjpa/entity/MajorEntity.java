package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "MAJOR")
public class MajorEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    public MajorEntity(){
    }
    public MajorEntity(String name, Boolean isActived){
        this.name = name;
        this.isActived = isActived;
    }
}