package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "USER")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private Boolean isActived;

    public UserEntity(){
    }

    public UserEntity(String username, String password, Boolean isActived, List<RoleEntity> roles) {
        this.username = username;
        this.password = password;
        this.isActived = isActived;
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(name = "User_Roles",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private List<RoleEntity> roles;
}