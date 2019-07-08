package com.yuri.twgerenciadortarefas.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;


@Entity
@Table(name="usr_usuarios")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="usr_id")
    private Long id;

    @Column(name="usr_email")
    @NotNull(message="O e-mail é obrigatório")
    private String email;

    @Column(name="usr_senha")
    @NotNull(message="A senha é obrigatória")
    private String password;


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}

//create table usr_usuarios (
//    usr_id int primary key auto_increment,
//    usr_email varchar(100) not null,
//    usr_senha varchar(100) not null
//);
