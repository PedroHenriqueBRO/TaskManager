package com.Pedro.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Pedro.TaskManager.model.Usuario;
import com.Pedro.TaskManager.repository.UsuarioRepository;

@Service
public class UsuarioService {
	//evita a criação de um construtor para receber um repository
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario us) {
		return repository.save(us);
		
	}
	public List<Usuario> listarTodos(){
		return repository.findAll();
	}
	public Usuario listarPorId(Long id) {
		return repository.findById(id).orElseThrow(()->new RuntimeException("Usuario nao encontrado"));
	}
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	public Usuario atualiza(Usuario us,Long id) {
		Usuario usnew = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario nao encontrado"));
		usnew.setEmail(us.getEmail());
		usnew.setNome(us.getNome());
		usnew.setTarefas(us.getTarefas());
		return repository.save(usnew);
	}
	

}
