package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import com.dev.java.learnspringjpa.model.request.save.LessonSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.LessonUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/get-all")
    public GeneralResponse<Object> getAll(){
        List<LessonEntity> datas = lessonService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data lesson", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody LessonSaveRequest request){
        return lessonService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        LessonEntity lesson = lessonService.getById(id);
        if (lesson.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data lesson", lesson);
        }
        return new GeneralResponse<>(100, "Failed", "Lesson with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-name")
    public GeneralResponse<Object> getByName(@RequestParam String name){
        List<LessonEntity> lesson = lessonService.getByName(name);
        if (lesson.getClass() != null){
            return new GeneralResponse<>(200, "Success", "Success get data lesson", lesson);
        }
        return new GeneralResponse<>(100, "Failed", "Lesson with name " + name + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody LessonUpdateRequest request){
        return lessonService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        LessonEntity lesson = lessonService.delete(id);
        if (lesson.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data lesson", lesson);
        }
        return new GeneralResponse<>(100, "Failed", "Lesson with id " + id + " is not found!", null);
    }
}
