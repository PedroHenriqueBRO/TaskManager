package com.Pedro.TaskManager.dto;

import java.util.ArrayList;
import java.util.List;

import com.Pedro.TaskManager.model.Tarefa;
import com.Pedro.TaskManager.model.Usuario;

public class UsuarioDTOAux {
	private Long id;
	private String nome;
	private String email;
	private String password;
	private List<TarefaDTO> tarefas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<TarefaDTO> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<TarefaDTO> tarefas) {
		this.tarefas = tarefas;
	}
	public static UsuarioDTO fromModel(Usuario user) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setNome(user.getNome());
		dto.setPassword(user.getPassword());
		List<TarefaDTO> lista = new ArrayList<>();
		if(user.getTarefas()!=null) {
		for(int i=0;i<user.getTarefas().size();i++) {
			lista.add(TarefaDTO.fromModel(user.getTarefas().get(i)));
		}
		}
		dto.setTarefas(lista);
		return dto;
		
	}
	public Usuario toModel() {
		Usuario user = new Usuario();
		user.setEmail(this.email);
		user.setId(this.id);
		user.setNome(this.nome);
		user.setPassword(this.password);
		List<Tarefa> lista = new ArrayList<>();
		if(this.tarefas!=null) {
		for(int i=0;i<tarefas.size();i++) {
			Tarefa nova = tarefas.get(i).toModel();
			nova.setUsuario(user);
			lista.add(nova);
		}
		}
		user.setTarefas(lista);
		return user;
	}
	

}
