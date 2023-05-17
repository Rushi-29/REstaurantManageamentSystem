package com.geekster.Restaurant.management.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "restaurantId",scope = Restaurant.class)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<FoodItem> menu ;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Admin personalDetails;
}
