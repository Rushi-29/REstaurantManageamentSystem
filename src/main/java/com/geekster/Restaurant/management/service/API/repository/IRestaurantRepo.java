package com.geekster.Restaurant.management.service.API.repository;

import com.geekster.Restaurant.management.service.API.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepo extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantId(Long id);

    void deleteByRestaurantId(Long id);
}
