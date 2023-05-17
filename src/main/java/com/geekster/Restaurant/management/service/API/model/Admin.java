package com.geekster.Restaurant.management.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "restaurantManagementRecordId",scope = Admin.class)
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantManagementRecordId;
    private String restaurantDescription;
    private String restaurantHeadChefName;
    private Integer restaurantHeadChefSalary;
    private int restaurantStaffsNumber;
    private Long restaurantStaffTotalExpense;

    @OneToOne
    private Restaurant restaurant;
}
