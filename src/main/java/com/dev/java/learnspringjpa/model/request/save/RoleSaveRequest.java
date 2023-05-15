package com.dev.java.learnspringjpa.model.request.save;

import lombok.Data;

@Data
public class RoleSaveRequest {
    private String name;
    private Boolean isActived;
}
