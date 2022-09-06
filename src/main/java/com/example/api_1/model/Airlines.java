package com.example.api_1.model;

import com.example.api_1.entity.AirlinesEntity;

public class Airlines {
    private long airlines_id;
    private String code;
    private String name;
    private String name_ru;
    private String country;
    private String country_ru;

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

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_ru() {
        return country_ru;
    }

    public void setCountry_ru(String country_ru) {
        this.country_ru = country_ru;
    }

    public static Airlines toModel(AirlinesEntity airlinesEntity){
        Airlines model = new Airlines();
        model.setAirlines_id(airlinesEntity.getAirlines_id());
        model.setCode(airlinesEntity.getCode());
        model.setName(airlinesEntity.getName());
        model.setName_ru(airlinesEntity.getName_ru());
        model.setCountry(airlinesEntity.getCountry());
        model.setCountry_ru(airlinesEntity.getCountry_ru());
        return model;
    }
}
