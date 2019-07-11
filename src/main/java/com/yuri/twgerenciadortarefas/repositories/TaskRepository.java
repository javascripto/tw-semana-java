package com.yuri.twgerenciadortarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yuri.twgerenciadortarefas.models.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.user.email = :email")
    List<Task> getTasksByUser(@Param("email") String email);
}
