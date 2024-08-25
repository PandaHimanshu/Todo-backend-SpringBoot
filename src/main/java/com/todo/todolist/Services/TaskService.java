package com.todo.todolist.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todolist.Entities.TaskEntity;
import com.todo.todolist.Repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    
    public List<TaskEntity> getAllTasks(){
        return taskRepository.findAll();
    }

    public String createTask(TaskEntity task){
         taskRepository.save(task);
         return "saved succesfully";
    }

    public Optional<TaskEntity> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public String deleteTask(Long id){
        taskRepository.deleteById(id);
        return "Delete succesfully";
    }

    public String updateTask(TaskEntity updateTask, Long id){
        return taskRepository.findById(id)
        .map(task->{
            task.setTitle(updateTask.getTitle());
            task.setDescription(updateTask.getDescription());

            taskRepository.save(task);
            return "Task updated successfully";
            
        }).orElse("Task not found");
    }
}
