package com.meistersolutions.api.services;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meistersolutions.api.entity.Task;
import com.meistersolutions.api.entity.TaskStatus;
import com.meistersolutions.api.exceptions.TaskNotFoundException;
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
            if(task.getStatus() != TaskStatus.PENDING) throw new TaskNotPendingOnAction();
        } else {
            LocalDate date = LocalDate.now();
            boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

            if(isWeekend) throw new TaskOnWeekDaysException();
        }

        return taskRepository.save(task);
    }

    public boolean removeTask(int taskId) throws TaskTooYoungToRemoveException, TaskNotPendingOnAction, TaskNotFoundException {
        List<Task> tasks = taskRepository.findById(taskId);

        if(tasks == null || tasks.isEmpty() || tasks.get(0) == null){
            throw new TaskNotFoundException();
        }

        Instant now = Instant.now();
        Instant taskCreationInstant = tasks.get(0).getCreationDate().toInstant();
        
        long minTaskLifespanInSeconds = 60L * 60L * 24L * 5L;
        long taskAgeInSeconds = ChronoUnit.SECONDS.between(taskCreationInstant, now);

        boolean canDelete = taskAgeInSeconds > minTaskLifespanInSeconds;
        if(!canDelete) throw new TaskTooYoungToRemoveException();

        if(tasks.get(0).getStatus() != TaskStatus.PENDING) throw new TaskNotPendingOnAction();

        taskRepository.deleteById(taskId);
        tasks = taskRepository.findById(taskId);
        if(tasks == null){
            return true;
        }

        return tasks.isEmpty();
    }

    public Task updateTaskStatus(int taskId) throws TaskNotFoundException {
        List<Task> tasks = taskRepository.findById(taskId);
        if(tasks == null || tasks.isEmpty() || tasks.get(0) == null){
            throw new TaskNotFoundException();
        }

        Task task = tasks.get(0);

        TaskStatus status = task.getStatus();
        task.setStatus(status.next());

        return taskRepository.save(task);
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
