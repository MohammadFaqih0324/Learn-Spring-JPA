package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    private LessonRepository repository;

    public LessonEntity save(String name, Boolean isActived, MajorEntity major){
        LessonEntity lesson = new LessonEntity(name, isActived, major);
        LessonEntity response = repository.save(lesson);
        return response;
    }
}
