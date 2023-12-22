package com.martijn.diningreviewapicodecademy.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByRestaurantName(String name);
     List<Restaurant> findAllByCityIgnoreCaseAndAverageReviewScoreIsNotNullOrderByAverageReviewScoreDesc(String city);
}
