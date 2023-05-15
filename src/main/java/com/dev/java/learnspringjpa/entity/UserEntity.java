package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "USER")
public class UserEntity extends BaseEntity {
    private String userName;
    private String password;
    private Boolean isActived;
    @ManyToMany
    @JoinTable(name = "User_Roles",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private List<RoleEntity> roles;

    public UserEntity(){
    }

    public UserEntity(String userName, String password, Boolean isActived, List<RoleEntity> roles) {
        this.userName = userName;
        this.password = password;
        this.isActived = isActived;
        this.roles = roles;
    }

    public UserEntity(UserEntity userEntity, String updateBy, String userName, String password, Boolean isActived, List<RoleEntity> roles) {
        super.setId(userEntity.getId());
        super.setCreatedDate(userEntity.getCreatedDate());
        super.setCreatedBy(userEntity.getCreatedBy());
        super.setUpdatedBy(userEntity.getUpdatedBy());
        this.userName = userName;
        this.password = password;
        this.isActived = isActived;
        this.roles = roles;
    }

    public String toString(){
        return "id = " + this.getId() + " name = " + this.getUserName();
    }
}