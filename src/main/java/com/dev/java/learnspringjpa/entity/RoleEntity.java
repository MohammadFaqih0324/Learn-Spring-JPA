package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "ROLE")
public class RoleEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    public RoleEntity(){
    }

    public RoleEntity(String name, Boolean isActived) {
        this.name = name;
        this.isActived = isActived;
    }

    public String toString(){
        return "id = " + this.getId() + " name = " + this.getName();
    }
}