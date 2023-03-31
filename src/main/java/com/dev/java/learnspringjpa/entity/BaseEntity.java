package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    @PrePersist
    private void beforeSave(){
        this.createdDate = new Date();
        this.createdBy = "Admin";
        this.updatedDate = new Date();
        this.updatedBy = "Admin";
    }
}