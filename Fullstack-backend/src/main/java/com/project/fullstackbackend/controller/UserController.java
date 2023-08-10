package com.project.fullstackbackend.controller;

import com.project.fullstackbackend.model.User;
import com.project.fullstackbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:3000")
public class UserController {

    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("Requesting Post....");
        User savedUser=service.createUser(user);
        log.debug("User Created {}",savedUser.toString());
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("user")
    public ResponseEntity<List<User>> getUsers(){
        log.info("Requesting for Get..");
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
    }
    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id")long id,@RequestBody User user){
        return new ResponseEntity<>(service.updateUser(user, id),HttpStatus.OK);

    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(service.deleteUser(id),HttpStatus.OK);
    }

}
