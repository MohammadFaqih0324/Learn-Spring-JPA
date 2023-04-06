package com.dev.java.learnspringjpa.repository;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, Long> {

    List<LessonEntity> findByName(String name);
}