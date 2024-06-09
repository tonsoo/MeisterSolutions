package com.meistersolutions.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meistersolutions.api.entity.Task;
import com.meistersolutions.api.services.TaskService;

@RestController
public class TaskController {
    
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return this.taskService.getTaskList(1);
    }

    @GetMapping("/task")
    public Task getTask(@RequestParam Integer taskId) {
        Optional<Task> task = this.taskService.getTask(taskId);
        return !task.isEmpty() ? task.get() : null;
    }
}
