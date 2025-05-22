package com.Pedro.TaskManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Pedro.TaskManager.model.Tarefa;

@Repository

public interface TarefaRepository extends JpaRepository<Tarefa,Long>{
	Optional<Tarefa> findByUsuarioId(Long userid);

}
