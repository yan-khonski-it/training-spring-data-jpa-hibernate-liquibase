package com.ff.liquibase.example.core.service.impl;

import com.ff.liquibase.example.core.entity.SomeEntity;
import com.ff.liquibase.example.core.repository.SomeEntityRepository;
import com.ff.liquibase.example.core.service.SomeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SomeEntityServiceImpl implements SomeEntityService {

    private SomeEntityRepository someEntityRepository;

    @Autowired
    public SomeEntityServiceImpl(SomeEntityRepository someEntityRepository) {
        this.someEntityRepository = someEntityRepository;
    }

    @Override
    public SomeEntity save(SomeEntity someEntity) {
        return someEntityRepository.save(someEntity);
    }

    @Override
    public List<SomeEntity> findAll() {
        return (List<SomeEntity>) someEntityRepository.findAll();
    }

    @Override
    public SomeEntity find(Long id) {
        return someEntityRepository.findOne(id);
    }
}