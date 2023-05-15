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

    public MajorEntity(MajorEntity majorEntity, String updateBy, String name, Boolean isActived){
        super.setId(majorEntity.getId());
        super.setCreatedDate(majorEntity.getCreatedDate());
        super.setCreatedBy(majorEntity.getCreatedBy());
        super.setUpdatedBy(majorEntity.getUpdatedBy());
        this.name = name;
        this.isActived = isActived;
    }
    public String toString(){
        return "id = " + this.getId() + " name = " + this.getName();
    }
}