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

    public RoleEntity(RoleEntity roleEntity, String updateBy, String name, Boolean isActived) {
        super.setId(roleEntity.getId());
        super.setCreatedDate(roleEntity.getCreatedDate());
        super.setCreatedBy(roleEntity.getCreatedBy());
        super.setUpdatedBy(updateBy);
        this.name = name;
        this.isActived = isActived;
    }

    public String toString(){
        return "id = " + this.getId() + " name = " + this.getName();
    }
}