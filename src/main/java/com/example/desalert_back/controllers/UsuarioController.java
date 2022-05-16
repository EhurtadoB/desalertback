package com.example.desalert_back.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.models.UsuarioModel;
import com.example.desalert_back.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuarios(usuario);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
	}
	
	@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorcargo(@RequestParam("cargo") String cargo){
		return this.usuarioService.obtenerPorCargo(cargo);
	}
	@DeleteMapping (path ="/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "se elimino el usuario con id "+id;
		}else {
			return "No puedoo eliminar el usuario con id "+id;
		}
	}
	

}
