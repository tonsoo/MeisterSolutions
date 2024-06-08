package com.meistersolutions.api.models;

public class User {

    private int Id;
    private String Name;
    private String Password;
    private String Email;

    public User(int id, String name, String password, String email) {
        this.Id = id;
        this.Name = name;
        this.Password = password;
        this.Email = email;
    }

    public int getId() {
        return this.Id;
    }

    public String getName() {
        return this.Name;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getEmail() {
        return this.Email;
    }
}
