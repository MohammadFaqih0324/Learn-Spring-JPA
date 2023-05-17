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

    public AddressEntity(AddressEntity addressEntity, String updateBy, String address){
        super.setId(addressEntity.getId());
        super.setCreatedDate(addressEntity.getCreatedDate());
        super.setCreatedBy(addressEntity.getCreatedBy());
        super.setUpdatedBy(updateBy);
        this.address = address;
    }

    public String toString(){
        return "id = " + this.getId() + " name = " + this.getAddress();
    }
}