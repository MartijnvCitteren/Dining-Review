package com.martijn.diningreviewapicodecademy.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String nameUser;
    private Long restaurantId;
    private int peanutScore;
    private int eggScore;
    private int dairyScore;
    private String comment;
    private ReviewStatus reviewStatus = ReviewStatus.NEW;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getPeanutScore() {
        return peanutScore;
    }

    public void setPeanutScore(int peanutScore) {
        this.peanutScore = peanutScore;
    }

    public int getEggScore() {
        return eggScore;
    }

    public void setEggScore(int eggScore) {
        this.eggScore = eggScore;
    }

    public int getDairyScore() {
        return dairyScore;
    }

    public void setDairyScore(int dairyScore) {
        this.dairyScore = dairyScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatus reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}
