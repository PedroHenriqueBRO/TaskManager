package com.Pedro.TaskManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Pedro.TaskManager.dto.TarefaDTO;
import com.Pedro.TaskManager.model.Tarefa;
import com.Pedro.TaskManager.service.TarefaService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
	@Autowired
	private TarefaService service;
	
	@PostMapping
	private TarefaDTO criarTarefa(@RequestBody @Valid TarefaDTO tr) {
		return TarefaDTO.fromModel(service.save(tr.toModel(),tr.getUsuarioId()));
	}
	@GetMapping
	private List<TarefaDTO> getTarefas() {
		List<TarefaDTO> lista = new ArrayList<>();
		List<Tarefa> tarefas = service.listarTodos();
		for(int i=0;i<tarefas.size();i++) {
			lista.add(TarefaDTO.fromModel(tarefas.get(i)));
		}
		return lista;
		
	}
	@GetMapping("/{id}")
	private TarefaDTO getTarefa(@PathVariable Long id) {
		return TarefaDTO.fromModel(service.listarPorId(id));
		
	}
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	@PutMapping("/{id}")
	private TarefaDTO atualiza(@PathVariable Long id,@RequestBody @Valid TarefaDTO tr) {
		tr.setId(id);
		return TarefaDTO.fromModel(service.atualiza(tr.toModel(),tr.getUsuarioId()));
		
	}
}
