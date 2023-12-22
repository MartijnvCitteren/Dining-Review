package com.martijn.diningreviewapicodecademy.Admin;

import com.martijn.diningreviewapicodecademy.Restaurant.Restaurant;
import com.martijn.diningreviewapicodecademy.Restaurant.RestaurantRepository;
import com.martijn.diningreviewapicodecademy.Review.Review;
import com.martijn.diningreviewapicodecademy.Review.ReviewRepository;
import com.martijn.diningreviewapicodecademy.Review.ReviewStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.round;

@Service
public class AdminService {

    DecimalFormat decimal = new DecimalFormat("0.00");
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public AdminService(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getNewReviews() {
        ReviewStatus reviewStatus = ReviewStatus.NEW;
        return reviewRepository.findAllByReviewStatus(reviewStatus);
    }

    public Review updateReviewStatus(Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(review.getId());
        if(optionalReview.isPresent()) {
            Review oldReview = optionalReview.get();
            oldReview.setReviewStatus(review.getReviewStatus());
            reviewRepository.save(oldReview);
            setReviewScores(review);
            return oldReview;
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void setReviewScores(Review review) {
        long restaurantId = review.getRestaurantId();
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()){
            Restaurant oldRestaurant = optionalRestaurant.get();

            int numReviews = oldRestaurant.getTotalReviews()+1;
            double averageDairyScore = Math.round(getAverageDairyScore(restaurantId)*100)/100D;
            double averageEggScore = Math.round(getAverageEggScore(restaurantId)*100)/100D;
            double averagePeanutScore = Math.round(getAveragePeanutScore(restaurantId)*100)/100D;
            double averageTotalScore = Math.round(((averageDairyScore + averagePeanutScore + averageEggScore) / 3)*100)/100D;

            oldRestaurant.setTotalReviews(numReviews);
            oldRestaurant.setDairyScore(averageDairyScore);
            oldRestaurant.setEggScore(averageEggScore);
            oldRestaurant.setPeanutScore(averagePeanutScore);
            oldRestaurant.setAverageReviewScore(averageTotalScore);
            restaurantRepository.save(oldRestaurant);
        }
        else {
            throw new IllegalArgumentException("Restaurant doesn't exist!");
        }

    }

    public double getAverageDairyScore(long id) {
        ArrayList<Review> reviews = (ArrayList<Review>) reviewRepository.getAllByRestaurantIdAndReviewStatusIs(id, ReviewStatus.ACCEPTED);
        int dairyscores = 0;
        int numReviews = 0;

        for (Review review : reviews) {
            dairyscores += (review.getDairyScore());
            numReviews++;
        }

        return (double) dairyscores / numReviews;
    }

    public double getAverageEggScore(long id) {
        ArrayList<Review> reviews = (ArrayList<Review>) reviewRepository.getAllByRestaurantIdAndReviewStatusIs(id, ReviewStatus.ACCEPTED);
        int eggScores = 0;
        int numReviews = 0;

        for (Review review : reviews) {
            eggScores += (review.getEggScore());
            numReviews++;
        }

        return (double) eggScores / numReviews;
    }

    public double getAveragePeanutScore(long id) {
        ArrayList<Review> reviews = (ArrayList<Review>) reviewRepository.getAllByRestaurantIdAndReviewStatusIs(id, ReviewStatus.ACCEPTED);
        int peanutScores = 0;
        int numReviews = 0;

        for (Review review : reviews) {
            peanutScores += (review.getPeanutScore());
            numReviews++;
        }

        return (double) peanutScores / numReviews;
    }

}
