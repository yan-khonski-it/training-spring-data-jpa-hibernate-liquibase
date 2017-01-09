package com.ff.liquibase.example.core.repository;

import com.ff.liquibase.example.core.base.BaseTest;
import com.ff.liquibase.example.core.entity.SomeEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Sql({"classpath:init.sql"})
@Sql(scripts = "classpath:clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class SomeEntityRepositoryTest extends BaseTest {

    @Autowired
    private SomeEntityRepository someEntityRepository;

    @Test
    public void shouldFindAll() {
        List<SomeEntity> allEntities = (List<SomeEntity>) someEntityRepository.findAll();
        Assert.assertNotNull(allEntities);
        Assert.assertFalse(allEntities.isEmpty());
    }
}
