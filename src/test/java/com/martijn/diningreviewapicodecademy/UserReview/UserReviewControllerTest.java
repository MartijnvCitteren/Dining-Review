package com.martijn.diningreviewapicodecademy.UserReview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserReviewControllerTest {

    @Mock
    UserReviewService userReviewService;

    @InjectMocks
    UserReviewController underTest;

    @Test
    void addUserShouldAddSuccessfully() {
        UserReview userReview = new UserReview();

    }

    @Test
    void findUserByName() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}