package com.example.api_1.model;

import com.example.api_1.entity.AirlinesEntity;

public class Airlines {
    private long airlines_id;
    private String code;
    private String name;
    private String country;

    public Airlines() {
    }

    public long getAirlines_id() {
        return airlines_id;
    }

    public void setAirlines_id(long airlines_id) {
        this.airlines_id = airlines_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Airlines toModel(AirlinesEntity airlinesEntity){
        Airlines model = new Airlines();
        model.setAirlines_id(airlinesEntity.getAirlines_id());
        model.setCode(airlinesEntity.getCode());
        model.setName(airlinesEntity.getName());
        model.setCountry(airlinesEntity.getCountry());
        return model;
    }
}
