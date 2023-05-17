package com.geekster.Restaurant.management.service.API.service;

import com.geekster.Restaurant.management.service.API.model.AuthenticationToken;
import com.geekster.Restaurant.management.service.API.model.User;
import com.geekster.Restaurant.management.service.API.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authenticationRepo;

    public void saveToken(AuthenticationToken token) {
        authenticationRepo.save(token);
    }

    public AuthenticationToken getToken(User user){
        return authenticationRepo.findByUser(user);
    }

    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authenticationToken = authenticationRepo.findFirstByToken(token);
        Optional<String> expectedMail = Optional.ofNullable(authenticationToken.getUser().getUserEmail());
        if(expectedMail.isPresent()){
            return true;
        }else
            return false;
    }
}
