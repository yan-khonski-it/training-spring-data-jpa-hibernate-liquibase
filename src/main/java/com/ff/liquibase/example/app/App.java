package com.ff.liquibase.example.app;


import com.ff.liquibase.example.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public void execute() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
    }
}