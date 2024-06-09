package com.meistersolutions.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meistersolutions.api.entity.Task;
import com.meistersolutions.api.repository.TaskRepository;

@Service
public class TaskService {

    @AutoWired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTaskByAdmin(int adminId){
        return taskRepository.findByAdmin_id(adminId);
    }

    public Task getTaskById(int taskId){
        List<Task> tasks = taskRepository.findById(taskId);
        if(tasks == null){
            return null;
        }

        return !tasks.isEmpty() ? tasks.get(0) : null;
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }
}
