package com.yuri.twgerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuri.twgerenciadortarefas.models.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
