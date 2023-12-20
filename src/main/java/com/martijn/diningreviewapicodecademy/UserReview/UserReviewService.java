package com.martijn.diningreviewapicodecademy.UserReview;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.RuntimeErrorException;

@Service
public class UserReviewService {

    private final UserReviewRepository userReviewRepository;

    public UserReviewService(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
    }

    public UserReview addUser(UserReview userReview) {
        if (userReviewRepository.existsByName(userReview.getName())) {
            throw new RuntimeException("Name already excists");
        }
        else {
            return userReviewRepository.save(userReview);
        }
    }

    public UserReview findUserByName(String name) {
        if (userReviewRepository.existsByName(name)) {
            return userReviewRepository.findUserReviewByName(name);
        }
        else {
            return null;
        }
    }





}
