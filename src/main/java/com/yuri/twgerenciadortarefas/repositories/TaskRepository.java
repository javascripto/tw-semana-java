package com.yuri.twgerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuri.twgerenciadortarefas.models.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
