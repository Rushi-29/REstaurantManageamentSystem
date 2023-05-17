package com.geekster.Restaurant.management.service.API.repository;

import com.geekster.Restaurant.management.service.API.model.Admin;
import com.geekster.Restaurant.management.service.API.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
    Admin findByRestaurant(Restaurant existingRestaurant);

    Admin findByRestaurantManagementRecordId(Long restaurantManagementRecordId);
}
