package com.meistersolutions.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/user/all")
    public List<Admin> getAdmins() {
        return adminService.getAdminList();
    }

    @CrossOrigin(origins="*")
    @PostMapping("/user/login")
    public Admin getAdmins(@RequestParam String email, @RequestParam String password) {
        List<Admin> admins = adminService.getAdminByEmailByPassword(email, password);

        return !admins.isEmpty() ? admins.get(0) : null;
    }
    
    @GetMapping("/user/{adminId}")
    public Admin getAdmin(@PathVariable(required=true,name="adminId") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/user/add")
    public Admin addAdmin(Admin admin) {
        System.out.println("Adding user");
        return adminService.addAdmin(admin);
    }
    
    @DeleteMapping("/user/remove/{adminId}")
    public boolean removeAdmin(@PathVariable(name="adminId",required=true) int adminId) {
        return adminService.removeAdmin(adminId);
    }
    
}
