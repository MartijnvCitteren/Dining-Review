package com.martijn.diningreviewapicodecademy.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        if (restaurantRepository.existsByRestaurantName(restaurant.getRestaurantName())){
            throw new RuntimeException("Restaurant aleady excists");
        }
        else {
            return restaurantRepository.save(restaurant);
        }
    }

    public Restaurant getRestaurantByID(long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurant.getId());
        Restaurant oldRestaurant = null;
        if (optionalRestaurant.isPresent()) {
            oldRestaurant = optionalRestaurant.get();
            oldRestaurant.setRestaurantName(restaurant.getRestaurantName());
            oldRestaurant.setCity(restaurant.getCity());
            restaurantRepository.save(oldRestaurant);
        } else {
            return new Restaurant();
        }
        return oldRestaurant;
    }

    public String deleteRestaurantById(long id) {
        restaurantRepository.deleteById(id);
        return "Restaurant is deleted";
    }
}
