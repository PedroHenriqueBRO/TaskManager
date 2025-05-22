package com.Pedro.TaskManager.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Tarefa {
	//fala que id será o id no banco de usuario, define a estratégia como sequence na qual o banco vai pesquisar toda vez o id para gerar o proximo
	//criando a partir de um gerador de sequencia com um nome , nome de sequencia e que vai alocar apenas um id por vez
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence_usuario" , sequenceName = "usuario_sequence",allocationSize = 1)
	private Long id;
	
	//tipo de tarefa nao pode ser nulo
	@NotBlank(message = "Tipo deve ter uma descrição")
	private String tipo_tarefa;
	
	//a data nao pode ter passado ja
	@FutureOrPresent(message="A data tem de ser futura ou atual!")
	private LocalDate data_limite;
	
	
	//relação muitos para um , com chave estrangeira definida como o id de usuario
	@ManyToOne 
	@JoinColumn(name="usuario_id")//Define qual coluna será considerada chave estrangeira
	@JsonBackReference
	private Usuario usuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo_tarefa() {
		return tipo_tarefa;
	}


	public void setTipo_tarefa(String tipo_tarefa) {
		this.tipo_tarefa = tipo_tarefa;
	}


	public LocalDate getData_limite() {
		return data_limite;
	}


	public void setData_limite(LocalDate data_limite) {
		this.data_limite = data_limite;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	

}
