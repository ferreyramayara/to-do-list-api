package com.mayara.todolist.service;

import com.mayara.todolist.model.Status;
import com.mayara.todolist.model.Tarefa;
import com.mayara.todolist.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa concluirTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));

        tarefa.setStatus(Status.CONCLUIDA);
        tarefa.setDataConclusao(LocalDateTime.now());
        return tarefaRepository.save(tarefa);
    }

    public Tarefa reabrirTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if (tarefa.getStatus() != Status.CONCLUIDA) {
            throw new RuntimeException("Apenas tarefas concluídas podem ser reabertas");
        }

        tarefa.setStatus(Status.PENDENTE);
        tarefa.setDataConclusao(null);

        return tarefaRepository.save(tarefa);
    }

    public Tarefa editarTitulo(Long id, String novoTitulo) {
        if (novoTitulo == null || novoTitulo.trim().isEmpty()) {
            throw new RuntimeException("Título não pode estar vazio.");
        }

        Tarefa tarefa = tarefaRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setTitulo(novoTitulo);

        return tarefaRepository.save(tarefa);
    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }
}
