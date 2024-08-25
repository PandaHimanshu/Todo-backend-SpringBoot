package com.todo.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todolist.Entities.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    
}
