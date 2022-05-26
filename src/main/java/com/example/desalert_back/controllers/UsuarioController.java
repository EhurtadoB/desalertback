package com.example.desalert_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.desalert_back.dto.UsuarioDTO;
import com.example.desalert_back.models.UsuarioModel;
import com.example.desalert_back.repositories.UsuarioRepository;
import com.example.desalert_back.services.UsuarioService;

@RestController
@RequestMapping("/api/")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioServicio;

	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	
	@PostMapping("/personas/{id}/usuario/{rolUsuario}")
	public ResponseEntity<?> guardarUsuario(@PathVariable(name = "id") long idPersona, @PathVariable(name = "rolUsuario") String rolUsuario,
			@RequestBody UsuarioDTO usuarioDTO) {
		
		return new ResponseEntity<>(usuarioServicio.crearUsuario(idPersona, usuarioDTO, rolUsuario), HttpStatus.CREATED);
	}
	
	@GetMapping("/personas/{idPersona}/usuario")
    public List<UsuarioDTO> listarUsuariosPorPersona(@PathVariable(name= "idPersona") long idPersona){
    	return usuarioServicio.obtenerUsuarioPorPersona(idPersona);
    }
	
	@GetMapping("/personas/{idPersona}/usuario/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable(name = "idPersona") long idPersona, @PathVariable(name = "id") long idUsuario){
    	
    	UsuarioDTO usuarioDTO = usuarioServicio.obtenerUsuarioPorId(idPersona, idUsuario);
    	
    	return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }
	
	@PutMapping("/personas/{idPersona}/usuario/{id}")
	public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable(name="idPersona") Long personaId, @PathVariable(name="id") Long usuarioId, @RequestBody UsuarioDTO usuarioDTO){
		UsuarioDTO usuarioActualizado = usuarioServicio.actualizarUsuario(personaId, usuarioId, usuarioDTO);
		return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
	}
	
	

}