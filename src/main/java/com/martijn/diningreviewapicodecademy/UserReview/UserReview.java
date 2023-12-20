package com.martijn.diningreviewapicodecademy.UserReview;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserReview {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String city;
    private String state;
    private String zipcode;
    private Boolean peanutAllergies;
    private Boolean eggAllergies;
    private Boolean dairyAllergies;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPeanutAllergies(Boolean peanutAllergies) {
        this.peanutAllergies = peanutAllergies;
    }

    public void setEggAllergies(Boolean eggAllergies) {
        this.eggAllergies = eggAllergies;
    }

    public void setDairyAllergies(Boolean dairyAllergies) {
        this.dairyAllergies = dairyAllergies;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Boolean getPeanutAllergies() {
        return peanutAllergies;
    }

    public Boolean getEggAllergies() {
        return eggAllergies;
    }

    public Boolean getDairyAllergies() {
        return dairyAllergies;
    }
}
