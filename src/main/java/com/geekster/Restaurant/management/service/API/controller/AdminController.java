package com.geekster.Restaurant.management.service.API.controller;

import com.geekster.Restaurant.management.service.API.model.Admin;
import com.geekster.Restaurant.management.service.API.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/restaurantid/{restaurantid}")
    public Admin getInformationOfRestaurantByRestaurantId(@PathVariable Long restaurantid){
        return adminService.getInformationOfRestaurantByRestaurantEmployeeRecordId(restaurantid);
    }

    @PutMapping("/restaurantid/{restaurantEmployeeRecordId}")
    public Admin updateInformationOfRestaurantByRestaurantId(@PathVariable Long restaurantEmployeeRecordId){
        return adminService.updateInformationOfRestaurantByRestaurantEmployeeRecordId(restaurantEmployeeRecordId);
    }
}
