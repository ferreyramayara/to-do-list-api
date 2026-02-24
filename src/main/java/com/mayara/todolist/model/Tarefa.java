package com.mayara.todolist.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private Status status;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.PENDENTE;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
