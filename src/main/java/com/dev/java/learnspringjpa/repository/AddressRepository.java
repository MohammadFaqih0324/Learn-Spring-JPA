package com.dev.java.learnspringjpa.repository;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    Optional<AddressEntity> findByAddress(String address);
}