package com.dev.java.learnspringjpa.model.request.save;

import lombok.Data;

import java.util.List;

@Data
public class StudentSaveRequest {
    private String name;
    private int age;
    private long major;
    private long address;
    private List<Long> course;
}