package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.MajorSaveRequest;
import lombok.Data;

@Data
public class MajorUpdateRequest extends MajorSaveRequest {
    private Long id;
    private String updateBy;
}
