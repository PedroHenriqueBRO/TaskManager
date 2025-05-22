package com.Pedro.TaskManager.model;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Usuario {
		//essas duas linhas definem que vai mapear o id para um id no banco ou seja transformar o id em uma coluna na tabela e
		//o generated value define a estratégia de coloca o id será gerado e a usada é definida de forma da escolha do banco e autoincremental
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		@SequenceGenerator(name = "seq_usuario", sequenceName = "usuario_seq", allocationSize = 1)
		private Long id;
		
		@NotBlank
		private String nome;
		
		//faz com que email nao possa ser nula e ser chave unique ou seja nao podem existir email igual no banco
		@NotBlank
		@Column(unique=true)
		private String email;
		
		//password nao pode ser nulo
		@NotBlank
		private String password;
		
		//mapeia um usuario para muitas tarefas e define o mapeamento que esse usuario esta mapeado em tarefa que contem um usuario
		//isso feito por mappedBy = "usuario" que diz que o campo usuario é o usuario mapeado nessa relação
		@OneToMany(mappedBy="usuario",cascade = CascadeType.ALL)
		@JsonManagedReference
		private List<Tarefa> tarefas=new ArrayList<>();

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Tarefa> getTarefas() {
			return tarefas;
		}

		public void setTarefas(List<Tarefa> tarefas) {
			this.tarefas = tarefas;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
