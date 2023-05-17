package com.geekster.Restaurant.management.service.API.repository;

import com.geekster.Restaurant.management.service.API.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<FoodItem, Long> {
}
