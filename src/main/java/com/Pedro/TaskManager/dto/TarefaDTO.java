package com.Pedro.TaskManager.dto;

import java.time.LocalDate;

import com.Pedro.TaskManager.model.Tarefa;

public class TarefaDTO {
       private Long id;
       private String tipo_tarefa;
       private LocalDate data_limite;
       private Long usuarioId;
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
	   
       public Long getUsuarioId() {
		return usuarioId;
	}
	   public void setUsuarioId(Long usuarioId) {
		   this.usuarioId = usuarioId;
	   }
	   public static TarefaDTO fromModel(Tarefa tarefa) {
    	   TarefaDTO dto = new TarefaDTO();
    	   dto.setId(tarefa.getId());
    	   dto.setTipo_tarefa(tarefa.getTipo_tarefa());
    	   dto.setData_limite(tarefa.getData_limite());
    	   if(tarefa.getUsuario().getId()!=null) {
    	   dto.setUsuarioId(tarefa.getUsuario().getId());
    	   }
    	   return dto;
       }
       public Tarefa toModel() {
    	   Tarefa tr = new Tarefa();
    	   tr.setId(this.id);
    	   tr.setData_limite(this.data_limite);
    	   tr.setTipo_tarefa(this.tipo_tarefa);
    	   return tr;
       }
}
