package com.geekster.Restaurant.management.service.API.service;

import com.geekster.Restaurant.management.service.API.model.Order;
import com.geekster.Restaurant.management.service.API.repository.IOrderRepo;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    IOrderRepo orderRepo;

    public void makeOrder(Order order){
        orderRepo.save(order);
    }
}
