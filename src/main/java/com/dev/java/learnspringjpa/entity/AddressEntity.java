package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity(name = "ADDRESS")
public class AddressEntity extends BaseEntity{
    private String address;
    @OneToOne(mappedBy = "address")
    private StudentEntity student;
}