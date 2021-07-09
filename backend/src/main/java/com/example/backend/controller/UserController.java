package com.example.backend.controller;

import com.example.backend.entity.user.StaffUser;
import com.example.backend.service.user.StaffUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StaffUserService staffUserService;

    //Endpoint to save server
    @PostMapping("/adduser")
    public StaffUser adduser(@RequestBody StaffUser staffUser){
        System.out.println(staffUser);
        return staffUserService.saveUser(staffUser);
    }

    //Endpoint to signin user
    @PostMapping("/signin")
    public String signin(@RequestBody StaffUser staffUser){
        return staffUserService.signIn(staffUser.getUsername(), staffUser.getPassword());
    }
}