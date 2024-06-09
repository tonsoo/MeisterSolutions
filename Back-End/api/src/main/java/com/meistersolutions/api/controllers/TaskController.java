package com.meistersolutions.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meistersolutions.api.entity.Task;
import com.meistersolutions.api.exceptions.TaskOnWeekDaysException;
import com.meistersolutions.api.exceptions.TaskTooYoungToRemoveException;
import com.meistersolutions.api.services.TaskService;

@RestController
public class TaskController {
    
    private TaskService taskService;

    @Autowired
    @Qualifier("taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/admin/{adminId}")
    public List<Task> getTasks(@PathVariable(name="adminId",required=true) Integer adminId) {
        return taskService.getTaskByAdmin(adminId);
    }

    @GetMapping("/task/{taskId}")
    public Task getTask(@PathVariable(name="taskId",required=true) Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/task/add")
    public Task addTask(Task task) throws TaskOnWeekDaysException{
        return taskService.addTask(task);
    }

    @DeleteMapping("/task/remove/{taskId}")
    public boolean removeTask(@PathVariable(name="taskId",required=true) int taskId) throws TaskTooYoungToRemoveException{
        return taskService.removeTask(taskId);
    }
}
