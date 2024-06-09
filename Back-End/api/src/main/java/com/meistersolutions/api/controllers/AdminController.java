package com.meistersolutions.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<Admin> getAdmins() {
        return adminService.getAdminList();
    }
    
    @GetMapping("/user/{adminId}")
    public Admin getAdmin(@PathVariable(required=true,name="adminId") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/user")
    public Admin addAdmin(Admin admin) {
        return adminService.addAdmin(admin);
    }
    
    
}
