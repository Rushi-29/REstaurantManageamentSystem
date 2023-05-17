package com.geekster.Restaurant.management.service.API.controller;
import com.geekster.Restaurant.management.service.API.dto.SignInInput;
import com.geekster.Restaurant.management.service.API.dto.SignInOutput;
import com.geekster.Restaurant.management.service.API.dto.SignUpInput;
import com.geekster.Restaurant.management.service.API.dto.SignUpOutput;
import com.geekster.Restaurant.management.service.API.model.FoodItem;
import com.geekster.Restaurant.management.service.API.service.AuthenticationService;
import com.geekster.Restaurant.management.service.API.service.FoodService;
import com.geekster.Restaurant.management.service.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FoodService foodService;

    //signup->signUp input -> signUp output

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpInput) {
        return userService.signUp(signUpInput);
    }

    @PostMapping("/signin")
    public SignInOutput signUp(@RequestBody SignInInput signInInput){
        return userService.signIn(signInInput);
    }

    @GetMapping("/food")
    public ResponseEntity<List<FoodItem>> getAllFoods(@RequestParam String userEmail, @RequestParam String token){
        HttpStatus status;
        List<FoodItem> foodList = null;
        //authenticate

        if(authenticationService.authenticate(userEmail,token)){
            foodList = foodService.showFood();
            status = HttpStatus.FOUND;
        }else{
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<FoodItem>>(foodList,status);
    }
}
