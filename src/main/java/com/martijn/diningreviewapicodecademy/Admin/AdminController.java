package com.martijn.diningreviewapicodecademy.Admin;

import com.martijn.diningreviewapicodecademy.Review.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/new")
    public List<Review> getNewReviews() {
        return adminService.getNewReviews();
    }

    @PutMapping()
    public Review updateReviewStatus(@RequestBody Review review) {
        return adminService.updateReviewStatus(review);
    }
}
