package com.mayara.todolist.Controller;

import com.mayara.todolist.model.Tarefa;
import com.mayara.todolist.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        List<Tarefa> tarefas = tarefaService.listarTodas();
        return ResponseEntity.ok(tarefas);
   }

   @PatchMapping("/{id}/concluir")
    public ResponseEntity<Tarefa> concluir(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.concluirTarefa(id);
        return ResponseEntity.ok(tarefa);
   }

   @PatchMapping("/{id}/reabrir")
    public ResponseEntity<Tarefa> reabrir(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.reabrirTarefa(id);
        return ResponseEntity.ok(tarefa);
   }
}
