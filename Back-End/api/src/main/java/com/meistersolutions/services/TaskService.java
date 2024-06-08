package com.meistersolutions.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.meistersolutions.api.models.Task;
import com.meistersolutions.api.models.TaskStatus;

@Service
public class TaskService {

    private final List<Task> taskList;

    public TaskService(){
        this.taskList = new ArrayList<>();

        taskList.addAll(List.of(
            new Task(1, "Limpar casa", "isso ae", TaskStatus.PENDING),
            new Task(2, "Meister solutions", "programar seguindo os passos", TaskStatus.IN_PROGRESS),
            new Task(3, "alooo", "isso nn", TaskStatus.PENDING),
            new Task(4, "testeee", "sakdsjdsad", TaskStatus.PENDING)
        ));
    }

    public List<Task> getTaskList(int userId){
        return this.taskList.stream().filter(t -> t.getUserId() == userId).collect(Collectors.toList());
    }

    public Optional<Task> getTask(Integer id){
        return taskList.stream()
           .filter(task -> task.getId() == id)
           .findFirst();
    }
}
