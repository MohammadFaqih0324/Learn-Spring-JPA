package com.dev.java.learnspringjpa.model.request;

import lombok.Data;

import java.util.List;

@Data
public class UserSaveRequest {
    private String userName;
    private String password;
    private Boolean isActived;
    private List<Long> role;
}
