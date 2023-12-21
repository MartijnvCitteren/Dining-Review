package com.martijn.diningreviewapicodecademy.UserReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    boolean existsByName(String name);

    boolean existsById(Long id);
    UserReview findUserReviewByName(String name);
}
