package com.meistersolutions.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.meistersolutions.api.models.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        this.userList = new ArrayList<>();

        userList.addAll(List.of(
            new User(1, "Alysson", "123", "alyssoncaoa@hotmail.com"),
            new User(2, "Eduardo", "Loak2+", "eduardooliveira9200@outlook.com"),
            new User(3, "João", "Senha123", "joao123@gmail.com"),
            new User(4, "Caroline Martins", "@Estr3las", "caroline.martins@gov.pr.br")
        ));
    }

    public Optional<User> getUser(Integer userId) {

        List<User> filteredList = this.userList.stream().filter(u -> u.getId() == userId).collect(Collectors.toList());

        return !filteredList.isEmpty() ? Optional.of(filteredList.get(0)) : Optional.empty();
    }
}
