package com.dev.java.learnspringjpa.model.request.update;

import com.dev.java.learnspringjpa.model.request.save.LessonSaveRequest;
import lombok.Data;
@Data
public class LessonUpdateRequest extends LessonSaveRequest {
    private Long id;
    private String updateBy;
}
