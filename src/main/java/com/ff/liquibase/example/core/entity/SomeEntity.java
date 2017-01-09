package com.ff.liquibase.example.core.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "some_entity")
public class SomeEntity {

    @Id
    @GeneratedValue(generator = "some_entity_id_seq")
    @SequenceGenerator(name = "some_entity_id_seq",sequenceName = "some_entity_id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "created")
    private LocalDateTime created;
}
