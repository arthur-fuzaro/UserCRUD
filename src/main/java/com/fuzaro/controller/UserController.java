package com.fuzaro.controller;


import com.fuzaro.business.UserBusiness;
import com.fuzaro.dto.request.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @PostMapping
    public ResponseEntity<UserInformation> createUser(@RequestBody UserInformation userInformation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userBusiness.createUser(userInformation));
    }

}
