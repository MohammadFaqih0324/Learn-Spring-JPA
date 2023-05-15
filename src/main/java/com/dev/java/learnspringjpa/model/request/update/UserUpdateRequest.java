package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.UserSaveRequest;
import lombok.Data;

@Data
public class UserUpdateRequest extends UserSaveRequest {
    private Long id;
    private String updateBy;
}
