package com.martijn.diningreviewapicodecademy.Review;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    private ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping("/newReview")
    public Review addReview(@RequestBody Review review, String userReviewName) {
        return reviewService.addReview(review);
    }
}
