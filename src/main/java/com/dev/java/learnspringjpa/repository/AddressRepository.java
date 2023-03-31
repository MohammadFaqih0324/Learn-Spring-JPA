package com.dev.java.learnspringjpa.repository;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}