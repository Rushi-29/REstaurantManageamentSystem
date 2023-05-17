package com.geekster.Restaurant.management.service.API.repository;

import com.geekster.Restaurant.management.service.API.model.AuthenticationToken;
import com.geekster.Restaurant.management.service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}

