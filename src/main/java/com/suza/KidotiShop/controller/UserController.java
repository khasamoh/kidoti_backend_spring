package com.suza.KidotiShop.controller;

import com.suza.KidotiShop.model.User;
import com.suza.KidotiShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user2")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/all")
    public ResponseEntity<?> getUser(){
        try {
            List<User> userList = userRepo.findAll();
            if(userList.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(userList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong, try again later",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("{UID}")
    private ResponseEntity<?>getUserById(@PathVariable int UID){
        Optional<User> optionalUser = userRepo.findById(UID);
        try {
            if (optionalUser.isEmpty()){
                return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(optionalUser,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Something wrong try again later",HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/adduser")
    private ResponseEntity<?>addUser(@RequestBody User user){
        try {
            User user1 = userRepo.save(user);
            return new ResponseEntity<>("Data Saved",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Data Not Saved",HttpStatus.CONFLICT);
        }
    }
}
