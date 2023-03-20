package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "STUDENT")
public class StudentEntity extends BaseEntity{
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "MAJOR")
    private MajorEntity major;

    @OneToOne
    @JoinColumn(name = "ADDRESS")
    private AddressEntity address;
}
