package com.mayara.todolist.service;

import com.mayara.todolist.model.Tarefa;
import com.mayara.todolist.repository.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criarTarefa(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new RuntimeException("O titulo é obrigatório.");
        }

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(titulo);

        return tarefaRepository.save(tarefa);
    }
}
