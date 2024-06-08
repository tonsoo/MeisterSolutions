package com.meistersolutions.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meistersolutions.entity.Admin;

@Service
public class AdminService {

    private final List<Admin> adminList;

    public AdminService(){
        this.adminList = new ArrayList<>();

        // userList.addAll(List.of(
        //     new User(1, "Alysson", "123", "alyssoncaoa@hotmail.com"),
        //     new User(2, "Eduardo", "Loak2+", "eduardooliveira9200@outlook.com"),
        //     new User(3, "João", "Senha123", "joao123@gmail.com"),
        //     new User(4, "Caroline Martins", "@Estr3las", "caroline.martins@gov.pr.br")
        // ));

        // String query = "SELECT * FROM users";
    }

    public Optional<Admin> getAdmin(Integer adminId) {

        return Optional.empty();
    }
}
