package com.yuri.twgerenciadortarefas.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="tar_tarefas")
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tar_id")
    private Long id;

    @Column(name="tar_titulo", length=50, nullable=false)
    @NotNull(message="O título é obrigatório")
    @Length(max=50, min=3, message="O Título deve conter entre 3 e 50 caracteres")
    private String title;

    @Column(name="tar_descricao", length=100)
    @Length(max=100, message="A descrição deve conter até 100 caracteres")
    private String description;

    @Column(name="tar_data_expiracao", nullable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;

    @Column(name="tar_concluida")
    private Boolean done = false;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="usr_id")
    private User user;

    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }

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


//ALTER TABLE tar_tarefas ADD COLUMN usr_id INT NOT NULL;
//    ALTER TABLE tar_tarefas
//    ADD CONSTRAINT fk_tar_tarefas_usr_usuarios
//    FOREIGN KEY (usr_id)
//    REFERENCES usr_usuario(usr_id);
