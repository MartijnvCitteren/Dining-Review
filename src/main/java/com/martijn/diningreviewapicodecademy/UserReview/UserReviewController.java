package com.martijn.diningreviewapicodecademy.UserReview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserReviewController {

    private final UserReviewService userReviewService;

    public UserReviewController (UserReviewService userReviewService){
        this.userReviewService = userReviewService;
    }

    @PostMapping("/addUser")
    public UserReview addUser(@RequestBody UserReview userReview){
        return userReviewService.addUser(userReview);
    }

    @GetMapping("/{name}")
    public UserReview findUserByName(@RequestParam String name) {
        return userReviewService.findUserByName(name);
    }

}
