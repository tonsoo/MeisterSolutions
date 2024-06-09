package com.meistersolutions.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meistersolutions.api.entity.Admin;
import com.meistersolutions.api.services.AdminService;


@RestController
public class AdminController {
    
    private AdminService adminService;

    @Autowired
    @Qualifier("adminService")
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/user")
    public Admin getUser(@RequestParam Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/user")
    public Admin addAdmin(Admin admin) {
        return adminService.addAdmin(admin);
    }
    
    
}
