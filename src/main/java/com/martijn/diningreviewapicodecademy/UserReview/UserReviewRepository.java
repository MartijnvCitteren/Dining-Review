package com.martijn.diningreviewapicodecademy.UserReview;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    Boolean existsByName(String name);
    UserReview findUserReviewByName(String name);
}
