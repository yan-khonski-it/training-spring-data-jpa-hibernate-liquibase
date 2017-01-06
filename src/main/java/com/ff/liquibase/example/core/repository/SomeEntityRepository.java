package com.ff.liquibase.example.core.repository;


import com.ff.liquibase.example.core.entity.SomeEntity;
import org.springframework.data.repository.CrudRepository;

public interface SomeEntityRepository extends CrudRepository<SomeEntity, Long> {
}