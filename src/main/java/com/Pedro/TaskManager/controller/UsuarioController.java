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
import com.Pedro.TaskManager.dto.UsuarioDTO;
import com.Pedro.TaskManager.dto.UsuarioDTOAux;
import com.Pedro.TaskManager.model.Usuario;
import com.Pedro.TaskManager.service.UsuarioService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    
	@PostMapping
	private UsuarioDTO salvar(@RequestBody @Valid UsuarioDTOAux dto) {
		return UsuarioDTO.fromModel(service.save(dto.toModel()));
		
	}
	@GetMapping 
	private List<UsuarioDTO> listarTodos(){
		List<UsuarioDTO> lista = new ArrayList<>();
		List<Usuario> usuarios = service.listarTodos();
		for(int i=0;i<usuarios.size();i++) {
			lista.add(UsuarioDTO.fromModel(usuarios.get(i)));
		}
		return lista;
	}
	@GetMapping("/{id}")
	private UsuarioDTO listaPorId(@PathVariable Long id) {
		return UsuarioDTO.fromModel(service.listarPorId(id));
	}
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	@PutMapping("/{id}")
	private UsuarioDTO atualiza(@PathVariable Long id,@RequestBody @Valid UsuarioDTO us) {
		us.setId(id);
		return UsuarioDTO.fromModel(service.atualiza(us.toModel(),id));
		
	}
	
}
