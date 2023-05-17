package com.geekster.Restaurant.management.service.API.service;

import com.geekster.Restaurant.management.service.API.model.Admin;
import com.geekster.Restaurant.management.service.API.model.FoodItem;
import com.geekster.Restaurant.management.service.API.model.Restaurant;
import com.geekster.Restaurant.management.service.API.repository.IRestaurantRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRepo iRestaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = iRestaurantRepository.findAll();
        return restaurantList;
    }

    public Restaurant getRestaurantById(Long id) {
        return iRestaurantRepository.findByRestaurantId(id);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = getRestaurantById(id);
        if(restaurant.getRestaurantName() != null) {
            existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        }
        List<FoodItem> foodList = restaurant.getMenu();
        for(FoodItem food : foodList){
            food.setRestaurant(restaurant);
        }
        Admin restaurantManagement = restaurant.getPersonalDetails();
        restaurantManagement.setRestaurant(restaurant);
        return iRestaurantRepository.save(existingRestaurant);
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        iRestaurantRepository.deleteByRestaurantId(id);
    }

    public void saveRestaurantDetails(Restaurant restaurant) {
        List<FoodItem> foodList = restaurant.getMenu();
        for(FoodItem food : foodList){
            food.setRestaurant(restaurant);
        }
        Admin restaurantManagement = restaurant.getPersonalDetails();
        restaurantManagement.setRestaurant(restaurant);
        iRestaurantRepository.save(restaurant);
    }
}
