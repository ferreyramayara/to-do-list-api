package com.mayara.todolist.repository;

import com.mayara.todolist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT t FROM Tarefa t")
    List<Tarefa>listarTodas();

    @Query("SELECT t FROM Tarefa t WHERE t.id = :id")
    Optional<Tarefa> buscarPorId(@Param("id") Long id);
}
