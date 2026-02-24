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

    private Boolean concluida = false;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        this.concluida = false;
    }

    public Long getId() {
        return id;
    }

    public Boolean getConcluida() {
        return concluida;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
