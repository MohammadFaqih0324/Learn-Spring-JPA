package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "USER")
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private Boolean isActived;
    @ManyToMany
    @JoinTable(name = "User_Roles",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private List<RoleEntity> roles;
}

