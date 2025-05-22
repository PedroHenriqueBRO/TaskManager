package com.Pedro.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pedro.TaskManager.model.Tarefa;
import com.Pedro.TaskManager.repository.TarefaRepository;

@Service
public class TarefaService {
	//evita a criação de um construtor para receber um repository
	@Autowired
	private TarefaRepository repository;
	@Autowired
	private UsuarioService usuarioService;
	
	public Tarefa save(Tarefa tr,Long id) {
		tr.setUsuario(usuarioService.listarPorId(id));
		return repository.save(tr);
	}
	public List<Tarefa> listarTodos(){
		return repository.findAll();
	}
	public Tarefa listarPorId(Long id) {
		return repository.findById(id).orElseThrow(()->new RuntimeException("Tarefa nao encontrada"));
	}
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	public Tarefa atualiza(Tarefa tr,Long id) {
		Tarefa trnew = repository.findById(tr.getId()).orElseThrow(()-> new RuntimeException("Tarefa nao encontrado"));
		trnew.setTipo_tarefa(tr.getTipo_tarefa());
		trnew.setData_limite(tr.getData_limite());
		trnew.setUsuario(usuarioService.listarPorId(id));
		return repository.save(trnew);
	}

}
