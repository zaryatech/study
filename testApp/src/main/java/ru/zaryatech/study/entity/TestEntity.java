package ru.zaryatech.study.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TestEntity {

    @Id
    @SequenceGenerator(name = "testEntity_seq", sequenceName = "test_entity_seq", allocationSize = 1)
    @GeneratedValue(generator = "testEntity_seq")
    private Long id;

    private String hello;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
