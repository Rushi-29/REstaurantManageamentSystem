package com.geekster.Restaurant.management.service.API.service;

import com.geekster.Restaurant.management.service.API.model.Admin;
import com.geekster.Restaurant.management.service.API.repository.IAdminRepo;
import com.geekster.Restaurant.management.service.API.repository.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    IRestaurantRepo iRestaurantRepository;

    public Admin getInformationOfRestaurantByRestaurantEmployeeRecordId(Long restaurantEmployeeRecordId) {
        return adminRepo.findByRestaurantManagementRecordId(restaurantEmployeeRecordId);
    }

    public Admin updateInformationOfRestaurantByRestaurantEmployeeRecordId(Long restaurantEmployeeRecordId) {
        Admin restaurantManagement = getInformationOfRestaurantByRestaurantEmployeeRecordId(restaurantEmployeeRecordId);
        if(restaurantManagement.getRestaurantDescription() != null) {
            restaurantManagement.setRestaurantDescription(restaurantManagement.getRestaurantDescription());
        }
        if(restaurantManagement.getRestaurantHeadChefName() != null) {
            restaurantManagement.setRestaurantHeadChefName(restaurantManagement.getRestaurantHeadChefName());
        }
        if(restaurantManagement.getRestaurantHeadChefSalary() != null){
            restaurantManagement.setRestaurantHeadChefSalary(restaurantManagement.getRestaurantHeadChefSalary());
        }
        if(restaurantManagement.getRestaurantStaffsNumber() != 0){
            restaurantManagement.setRestaurantStaffsNumber(restaurantManagement.getRestaurantStaffsNumber());
        }
        if(restaurantManagement.getRestaurantStaffTotalExpense() != 0){
            restaurantManagement.setRestaurantStaffsNumber(restaurantManagement.getRestaurantStaffsNumber());
        }
        return adminRepo.save(restaurantManagement);
    }
}
