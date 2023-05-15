package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.RoleSaveRequest;
import lombok.Data;

@Data
public class RoleUpdateRequest extends RoleSaveRequest {
    private Long id;
    private String updateBy;
}
