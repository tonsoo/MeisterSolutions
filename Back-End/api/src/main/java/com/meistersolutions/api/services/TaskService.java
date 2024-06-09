package com.meistersolutions.api.services;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meistersolutions.api.entity.Task;
import com.meistersolutions.api.entity.TaskStatus;
import com.meistersolutions.api.exceptions.TaskNotPendingOnAction;
import com.meistersolutions.api.exceptions.TaskOnWeekDaysException;
import com.meistersolutions.api.exceptions.TaskTooYoungToRemoveException;
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

    public Task addTask(Task task) throws TaskOnWeekDaysException, TaskNotPendingOnAction {
        if(task.getId() != 0){
            LocalDate date = LocalDate.now();
            boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY;

            if(isWeekend) throw new TaskOnWeekDaysException();

            if(task.getStatus() != TaskStatus.PENDING) throw new TaskNotPendingOnAction();
        }

        return taskRepository.save(task);
    }

    public boolean removeTask(int taskId) throws TaskTooYoungToRemoveException, TaskNotPendingOnAction{
        List<Task> tasks = taskRepository.findById(taskId);

        if(tasks != null && !tasks.isEmpty() && tasks.get(0) != null){
            Date now = Date.from(Instant.now());
            Date taskCreation = tasks.get(0).getCreationDate();

            int minTaskLifespan = 60 * 60 * 24 * 5; // 60 seconds * 60 minutes * 24 hours * 5 days
            boolean canDelete = minTaskLifespan < now.getTime() - taskCreation.getTime();
            if(!canDelete) throw new TaskTooYoungToRemoveException();

            if(tasks.get(0).getStatus() != TaskStatus.PENDING) throw new TaskNotPendingOnAction();
        }

        taskRepository.deleteById(taskId);
        tasks = taskRepository.findById(taskId);
        if(tasks == null){
            return true;
        }

        return tasks.isEmpty();
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
