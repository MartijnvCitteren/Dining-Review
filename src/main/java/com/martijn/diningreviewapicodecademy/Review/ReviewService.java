package com.martijn.diningreviewapicodecademy.Review;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review, ) {
        if ()
        return reviewRepository.save(review);
    }
}
