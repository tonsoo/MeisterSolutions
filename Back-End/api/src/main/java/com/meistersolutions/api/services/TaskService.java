package com.meistersolutions.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.meistersolutions.api.entity.Task;

@Service
public class TaskService {

    private final List<Task> taskList;

    public TaskService(){
        this.taskList = new ArrayList<>();
    }

    public List<Task> getTaskList(int userId){
        return this.taskList.stream().filter(t -> t.getAdmin().getId() == userId).collect(Collectors.toList());
    }

    public Optional<Task> getTask(Integer id){
        return taskList.stream()
           .filter(task -> task.getId() == id)
           .findFirst();
    }
}
