package com.example.api_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "airlines")
public class AirlinesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airlines_id;
    private String code;
    private String name;

    @JsonIgnore
    private String name_ru;

    private String country;

    @JsonIgnore
    private String country_ru;

    @JsonIgnore
    private String logo;

    @JsonIgnore
    private int is_published;

    public AirlinesEntity() {
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getIs_published() {
        return is_published;
    }

    public void setIs_published(int is_published) {
        this.is_published = is_published;
    }
}
