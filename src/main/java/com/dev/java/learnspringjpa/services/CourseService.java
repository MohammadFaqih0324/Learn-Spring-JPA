package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity save(String name, Boolean isActived) {
        CourseEntity courseEntity = new CourseEntity(name, isActived);
        CourseEntity response = courseRepository.save(courseEntity);
        return response;
    }
}
