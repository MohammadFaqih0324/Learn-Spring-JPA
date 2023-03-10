package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.aspectj.weaver.IClassFileProvider;

import java.util.Date;

@Entity(name = "USER")
public class UserEntity {

    @Id
    private Long id;
    private String username;
    private String password;
    private Boolean isActived;
    private Long role;
    private Date createdDate;
    private String createdBy;
    private Date updateDate;
    private String updateBy;
}
