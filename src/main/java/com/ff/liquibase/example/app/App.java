package com.ff.liquibase.example.app;


import com.ff.liquibase.example.configuration.AppConfig;
import com.ff.liquibase.example.core.entity.SomeEntity;
import com.ff.liquibase.example.core.service.SomeEntityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class App {

    public void execute() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SomeEntityService service = (SomeEntityService) ctx.getBean("someEntityService");

        SomeEntity s1 = new SomeEntity();
        s1.setText("t1");
        s1.setCreated(LocalDateTime.now());
        service.save(s1);
        List<SomeEntity> entities = service.findAll();
        SomeEntity s2 = entities.get(0);
        System.out.println(s1.getId());
        System.out.println(s2.getId() + " " + s2.getText() + " " + s2.getCreated());
    }
}