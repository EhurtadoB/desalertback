package com.example.desalert_back.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.desalert_back.dto.UsuarioDTO;

public interface UsuarioService {
	
	public ResponseEntity<?> crearUsuario(long personaId, UsuarioDTO usuarioDTO, String rol);
	
	public List<UsuarioDTO> obtenerUsuarioPorPersona(long personaId);
	
	public UsuarioDTO obtenerUsuarioPorId(Long personaId, Long usuarioId);
	
	public UsuarioDTO actualizarUsuario(Long personaId, Long usuarioId, UsuarioDTO solicitudDeUsuario);
	
}