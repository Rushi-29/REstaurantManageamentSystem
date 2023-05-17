package com.geekster.Restaurant.management.service.API.service;

import com.geekster.Restaurant.management.service.API.model.FoodItem;
import com.geekster.Restaurant.management.service.API.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo iFoodRepository;

    public List<FoodItem> showFood() {
        return iFoodRepository.findAll();
    }
}
