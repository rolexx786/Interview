package com.UserLogin.controller;

import com.UserLogin.entiry.Jwtresponse;
import com.UserLogin.entiry.LoginDto;
import com.UserLogin.entiry.User;
import com.UserLogin.service.Userservice;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private Userservice userservice;

    public UserController(Userservice userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userservice.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<Jwtresponse > verifyLogin(@RequestBody LoginDto dto){
        Jwtresponse jwtresponse = userservice.verifyLogin(dto);
        return new ResponseEntity<>(jwtresponse, HttpStatus.CREATED);

    }

    @PostMapping("/createGalary")
    public ResponseEntity<String> createGalary(){
        return new ResponseEntity<>("Galary Created", HttpStatus.CREATED);
    }

    @GetMapping("/getImages")
    public ResponseEntity<String> getAllImages(){
        return new ResponseEntity<>("All images fetched", HttpStatus.OK);
    }
}
