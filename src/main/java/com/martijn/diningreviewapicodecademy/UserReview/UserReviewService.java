package com.martijn.diningreviewapicodecademy.UserReview;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserReviewService {

    private final UserReviewRepository userReviewRepository;

    public UserReviewService(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
    }

    public UserReview addUser(UserReview userReview) {
        if (userReviewRepository.existsByName(userReview.getName())) {
            throw new RuntimeException("Name already exists");
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


    public UserReview updateUser(UserReview userReview) {
        Optional<UserReview> optionalUserReview = userReviewRepository.findById(userReview.getId());
        UserReview oldUser = null;
        if (optionalUserReview.isPresent()) {
            oldUser = optionalUserReview.get();
            oldUser.setCity(userReview.getCity());
            oldUser.setState(userReview.getState());
            oldUser.setZipcode(userReview.getZipcode());
            oldUser.setDairyAllergies(userReview.getDairyAllergies());
            oldUser.setEggAllergies(userReview.getEggAllergies());
            oldUser.setPeanutAllergies(userReview.getPeanutAllergies());
            userReviewRepository.save(oldUser);
        }
        else {
            return new UserReview();
        }
        return  oldUser;
    }

    public UserReview deleteUser(Long id) {
        if (userReviewRepository.existsById(id)) {
            userReviewRepository.deleteById(id);
        }
        return null;
    }
}
