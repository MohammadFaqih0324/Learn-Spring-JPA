package com.dev.java.learnspringjpa.repository;

import com.dev.java.learnspringjpa.entity.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MajorRepository extends JpaRepository<MajorEntity, Long> {

    Optional<MajorEntity> findByName(String name);
}