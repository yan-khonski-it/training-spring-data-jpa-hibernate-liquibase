package com.ff.liquibase.example.core.entity;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class SomeEntityTest {

    @Test
    public void shouldGettersAndSettersWork() {
        Long id = 123L;
        String text = "Ann";
        LocalDateTime created = LocalDateTime.of(1999, 11, 1, 12, 5);
        SomeEntity someEntity = new SomeEntity();
        someEntity.setId(id);
        someEntity.setText(text);
        someEntity.setCreated(created);
        Assert.assertNotNull(someEntity);
        Assert.assertEquals(id, someEntity.getId());
    }
}
