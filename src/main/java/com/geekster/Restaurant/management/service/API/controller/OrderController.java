package com.geekster.Restaurant.management.service.API.controller;

import com.geekster.Restaurant.management.service.API.model.FoodItem;
import com.geekster.Restaurant.management.service.API.model.Order;
import com.geekster.Restaurant.management.service.API.service.AuthenticationService;
import com.geekster.Restaurant.management.service.API.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<String> makeOrder(@RequestParam String userEmail, @RequestParam String token ,@RequestBody Order order){
        HttpStatus status;
        String massage;
        //authenticate
        if (authenticationService.authenticate(userEmail, token)) {
            orderService.makeOrder(order);
            status = HttpStatus.FOUND;
            massage = "orderd Successfully...!!!!";
        } else {
            status = HttpStatus.FORBIDDEN;
            massage = "order not executed...!!!";
        }
        return new ResponseEntity<String>(massage,status);
    }
}
