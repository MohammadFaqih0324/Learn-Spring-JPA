package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.CourseSaveRequest;
import lombok.Data;

@Data
public class CourseUpdateRequest extends CourseSaveRequest {
    private Long id;
    private String updateBy;
}
