package com.ff.liquibase.example.core.base;

import com.ff.liquibase.example.configuration.AppConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * A class a repository or service test should extend in order its fields to be spring autowired.
 * It's abstract because it does not test anything.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public abstract class BaseTest {
}
