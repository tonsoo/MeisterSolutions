package com.meistersolutions.api.models;


public class Task {
    
    private int id;
    private int userId;
    private String name;
    private String description;
    private TaskStatus status;

    private void Init(int id, String name, String description, TaskStatus status){
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Task(String name, String description, TaskStatus status) {
        this.Init(0, name, description, status);
    }

    public Task (int id, String name, String description, TaskStatus status) {
        this.Init(id, name, description, status);
    }

    public int getId(){
        return this.id;
    }

    public int getUserId(){
        return this.userId;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public TaskStatus getStatus(){
        return this.status;
    }
}
