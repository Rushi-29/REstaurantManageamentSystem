package com.geekster.Restaurant.management.service.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer quantity;

    private String status;
    @OneToOne
    private FoodItem food;
    @OneToOne
    private User user;
    @OneToOne
    private Restaurant restaurant;

}
