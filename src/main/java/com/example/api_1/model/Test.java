package com.example.api_1.model;

import com.example.api_1.entity.TestEntity;

public class Test {
    private long id;
    private String name;
    private String city;

    public Test() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static Test toModel(TestEntity testEntity){
        Test model = new Test();
        model.setId(testEntity.getId());
        model.setName(testEntity.getUsername());
        model.setCity(testEntity.getCity());
        return model;
    }


}
