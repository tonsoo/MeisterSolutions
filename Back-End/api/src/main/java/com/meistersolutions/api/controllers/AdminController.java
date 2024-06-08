package com.meistersolutions.api.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meistersolutions.entity.Admin;
import com.meistersolutions.services.AdminService;

@RestController
public class AdminController {
    
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/user")
    public Admin getUser(@RequestParam Integer id) {

        Optional<Admin> user = adminService.getAdmin(id);

        return user.isPresent() ? ((Admin) user.get()) : null;
    }
    
}
