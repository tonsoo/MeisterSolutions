package com.meistersolutions.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meistersolutions.api.entity.Admin;
import com.meistersolutions.api.repository.AdminRepository;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdminList() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int id){
        List<Admin> admins = adminRepository.findById(id);
        if(admins == null){
            return null;
        }

        return !admins.isEmpty() ? admins.get(0) : null;
    }

    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }
}
