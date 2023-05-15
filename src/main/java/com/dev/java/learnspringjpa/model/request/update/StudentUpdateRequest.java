package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.StudentSaveRequest;
import lombok.Data;

@Data
public class StudentUpdateRequest extends StudentSaveRequest {
    private Long id;
    private String updateBy;
}
