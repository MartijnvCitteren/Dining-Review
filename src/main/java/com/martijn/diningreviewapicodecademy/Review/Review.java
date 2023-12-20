package com.martijn.diningreviewapicodecademy.Review;

import com.martijn.diningreviewapicodecademy.Admin.ReviewStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private String name;
    private Long restaurantId;
    private int peanutScore;
    private int eggScore;
    private int dairyScore;
    private String comment;
    private ReviewStatus reviewStatus;
}
