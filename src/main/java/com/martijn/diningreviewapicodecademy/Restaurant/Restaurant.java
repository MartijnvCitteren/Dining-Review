package com.martijn.diningreviewapicodecademy.Restaurant;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private long id;
    private String restaurantName;
    private String city;
    private Double averageReviewScore;
    private Double peanutScore;
    private Double dairyScore;
    private Double eggScore;
    private int totalReviews;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getAverageReviewScore() {
        return averageReviewScore;
    }

    public void setAverageReviewScore(Double averageReviewScore) {
        this.averageReviewScore = averageReviewScore;
    }

    public Double getPeanutScore() {
        return peanutScore;
    }

    public void setPeanutScore(Double peanutScore) {
        this.peanutScore = peanutScore;
    }

    public Double getDairyScore() {
        return dairyScore;
    }

    public void setDairyScore(Double dairyScore) {
        this.dairyScore = dairyScore;
    }

    public Double getEggScore() {
        return eggScore;
    }

    public void setEggScore(Double eggScore) {
        this.eggScore = eggScore;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }
}
