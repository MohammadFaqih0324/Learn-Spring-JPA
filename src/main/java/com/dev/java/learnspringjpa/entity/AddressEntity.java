package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity(name = "ADDRESS")
public class AddressEntity extends BaseEntity{
    private String address;
    public AddressEntity(){
    }
    public AddressEntity(String address){
        this.address = address;
    }
}