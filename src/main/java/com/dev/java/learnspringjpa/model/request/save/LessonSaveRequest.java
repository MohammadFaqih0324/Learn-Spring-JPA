package com.dev.java.learnspringjpa.model.request.save;

import lombok.Data;
@Data
public class LessonSaveRequest {
    private String name;
    private Boolean isActived;
    private long major;
}
