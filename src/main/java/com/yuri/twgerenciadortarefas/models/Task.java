package com.yuri.twgerenciadortarefas.models;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="tar_tarefas")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tar_id")
    private Long id;

    @Column(name="tar_titulo", length=50, nullable=false)
    private String title;

    @Column(name="tar_descricao", length=100)
    private String description;

    @Column(name="tar_data_expiracao", nullable=false)
    private Date expirationDate;

    @Column(name="tar_concluida")
    private Boolean done = false;


    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Task setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Boolean getDone() {
        return done;
    }

    public Task setDone(Boolean done) {
        this.done = done;
        return this;
    }
}

//create table tar_tarefas (
//     tar_id int primary key auto_increment,
//     tar_titulo varchar(50) not null,
//     tar_descricao varchar(100) default null,
//     tar_data_expiracao date not null,
//     tar_concluida bit default,
// );
