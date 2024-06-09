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

    public List<Admin> getAdminByEmailByPassword(String email, String password){
        List<Admin> admins = adminRepository.findByEmailAndPass(email, password);
        if(admins == null){
            return null;
        }

        return admins;
    }

    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public boolean removeAdmin(int adminId){
        adminRepository.deleteById(adminId);

        List<Admin> admins = adminRepository.findById(adminId);
        if(admins == null){
            return true;
        }

        return admins.isEmpty();
    }
}
