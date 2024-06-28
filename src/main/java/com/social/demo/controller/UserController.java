package com.social.demo.controller;


import com.social.demo.models.User;
import com.social.demo.repository.UserRepository;
import com.social.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user){

        User savedUser = userService.registerUser(user);
        return savedUser;
    }

    @GetMapping("/users")
    public List<User> getUsers(){

        List<User> users = userRepository.findAll();


        return  users;


    }


    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer id) throws Exception {

        User user = userService.findUserById(id);
        return user;
    }



    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception {

        User updatedUser = userService.updatUser(user,userId);
        return  updatedUser;
    }

    @DeleteMapping("/users/{userid}")
    public String deleteUser(@PathVariable("userid") Integer userId ) throws Exception {

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            throw new Exception("user not exist with id "+userId);
        }
        userRepository.delete(user.get());
        return "user deleted successfully with id "+userId;
    }

    @PutMapping("/users/follow/{userId1}/{userId2}")
    public  User followUserHandler(@PathVariable Integer userId1,
                                   @PathVariable Integer userId2) throws Exception {

        User user = userService.followUser(userId1,userId2);
        return  user;
    }


    @GetMapping("/users/search")
    public  List<User> serachUser(@RequestParam("query") String query){

        List<User> user = userService.searchUser(query);
        return  user;
    }

}
