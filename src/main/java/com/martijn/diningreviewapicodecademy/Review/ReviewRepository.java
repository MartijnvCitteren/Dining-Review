package com.martijn.diningreviewapicodecademy.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByReviewStatus(ReviewStatus reviewStatus);

    List<Review> getAllByRestaurantIdAndReviewStatusIs(Long id, ReviewStatus reviewStatus);

}

