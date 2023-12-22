package com.martijn.diningreviewapicodecademy.Restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable long id) {
        return restaurantService.getRestaurantByID(id);
    }

    @GetMapping("/all/{city}")
    public List<Restaurant> getRestaurantsByCityAndReview(@PathVariable String city) {
        return restaurantService.getRestaurantsByCityAndReview(city);
    }

    @PutMapping("/update")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable long id) {
        return restaurantService.deleteRestaurantById(id);
    }
}
