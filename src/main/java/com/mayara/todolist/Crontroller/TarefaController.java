package com.mayara.todolist.Crontroller;

import com.mayara.todolist.model.Tarefa;
import com.mayara.todolist.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }


   @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa nova = tarefaService.criarTarefa(tarefa.getTitulo());
        return ResponseEntity.status(201).body(nova);
   }
}
