package com.martijn.diningreviewapicodecademy.Review;

import com.martijn.diningreviewapicodecademy.Restaurant.RestaurantRepository;
import com.martijn.diningreviewapicodecademy.Restaurant.RestaurantService;
import com.martijn.diningreviewapicodecademy.UserReview.UserReview;
import com.martijn.diningreviewapicodecademy.UserReview.UserReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserReviewRepository userReviewRepository;


    private ReviewService(ReviewRepository reviewRepository, UserReviewRepository userReviewRepository) {
        this.reviewRepository = reviewRepository;
        this.userReviewRepository = userReviewRepository;
    }

    public Review addReview(Review review) {
        if (userReviewRepository.existsByName(review.getNameUser())) {
            return reviewRepository.save(review);
        }
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
