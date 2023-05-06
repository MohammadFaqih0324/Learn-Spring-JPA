package com.dev.java.learnspringjpa.model.request;

import lombok.Data;

@Data
public class RoleSaveRequest {
    private String name;
    private Boolean isActived;
}
