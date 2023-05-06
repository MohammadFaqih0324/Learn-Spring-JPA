package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.model.request.LessonSaveRequest;
import com.dev.java.learnspringjpa.model.request.MajorSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private MajorService majorService;

    @GetMapping("/get-all")
    public GeneralResponse getAll(){
        List<LessonEntity> datas = lessonService.getAll();
        return new GeneralResponse(200, "Success", "Success get data lesson", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody LessonSaveRequest request){
        GeneralResponse response = lessonService.save(request);
        return response;
    }
}
