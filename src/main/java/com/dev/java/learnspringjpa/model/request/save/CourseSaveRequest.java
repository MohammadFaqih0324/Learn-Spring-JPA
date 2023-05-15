package com.dev.java.learnspringjpa.model.request.save;

import lombok.Data;

@Data
public class CourseSaveRequest {
    private String name;
    private Boolean isActived;
}
