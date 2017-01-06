package com.ff.liquibase.example.core.service;

import com.ff.liquibase.example.core.entity.SomeEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface SomeEntityService {

    @Transactional
    public SomeEntity save(SomeEntity someEntity);

    public List findAll();

    public SomeEntity find(Long id);
}