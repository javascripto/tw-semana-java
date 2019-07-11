package com.yuri.twgerenciadortarefas.models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="usr_usuarios")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="usr_id")
    private Long id;

    @Column(name="usr_email")
    @NotNull(message="O e-mail é obrigatório")
    @Length(min=5, max=100, message="O e-mail deve conter entre 5 e 100 caracteres.")
    private String email;

    @Column(name="usr_senha")
    @NotNull(message="A senha é obrigatória")
    private String password;

    @OneToMany(mappedBy="user", fetch= FetchType.LAZY)
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public User setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

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
