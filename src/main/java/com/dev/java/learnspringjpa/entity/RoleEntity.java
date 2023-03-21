package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity(name = "ROLE")
public class RoleEntity extends BaseEntity{
    private String name;
    private Boolean isActived;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
}