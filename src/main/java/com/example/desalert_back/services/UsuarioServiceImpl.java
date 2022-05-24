package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desalert_back.dto.UsuarioDTO;
import com.example.desalert_back.excepciones.ControlAppException;
import com.example.desalert_back.excepciones.ResourceNotFoundException;
import com.example.desalert_back.models.PersonaModel;
import com.example.desalert_back.models.UsuarioModel;
import com.example.desalert_back.repositories.PersonaRepository;
import com.example.desalert_back.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	@Autowired
	PersonaRepository personaRepositorio;
	
	@Override
	public UsuarioDTO crearUsuario(long personaId, UsuarioDTO usuarioDTO) {
		UsuarioModel usuario = mapearEntidad(usuarioDTO);
		PersonaModel persona = personaRepositorio.findById(personaId)
				.orElseThrow(()->new ResourceNotFoundException("persona", "id", personaId));
		
		usuario.setPersona(persona);
		
		UsuarioModel nuevoUsuario = usuarioRepositorio.save(usuario);

		return mapearDTO(nuevoUsuario);
	}
	
	// convertir a DTO
	private UsuarioDTO mapearDTO(UsuarioModel usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();

		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setContrasena(usuario.getContrasena());

		return usuarioDTO;
	}

	// convertir a Entidad
	private UsuarioModel mapearEntidad(UsuarioDTO usuarioDTO) {
		UsuarioModel usuario = new UsuarioModel();

		usuario.setId(usuarioDTO.getId());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setContrasena(usuarioDTO.getContrasena());

		return usuario;
	}

	@Override
	public List<UsuarioDTO> obtenerUsuarioPorPersona(long personaId) {
		List<UsuarioModel> usuario = usuarioRepositorio.findByPersonaId(personaId);
		return usuario.stream().map(usuar -> mapearDTO(usuar)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO obtenerUsuarioPorId(Long personaId, Long usuarioId) {
		PersonaModel persona = personaRepositorio.findById(personaId)
				.orElseThrow(()->new ResourceNotFoundException("persona", "id", personaId));
		
		UsuarioModel usuario = usuarioRepositorio.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));
		
		if(!usuario.getPersona().getId().equals(persona.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Usuario no pertenece a la Persona");
		}
		
		return mapearDTO(usuario);
	}

	@Override
	public UsuarioDTO actualizarUsuario(Long personaId, Long usuarioId, UsuarioDTO solicitudDeUsuario) {
		PersonaModel persona = personaRepositorio.findById(personaId)
				.orElseThrow(()->new ResourceNotFoundException("persona", "id", personaId));
		
		UsuarioModel usuario = usuarioRepositorio.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));
		
		if(!usuario.getPersona().getId().equals(persona.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Usuario no pertenece a la Persona");
		}
		
		usuario.setEmail(solicitudDeUsuario.getEmail());
		usuario.setContrasena(solicitudDeUsuario.getContrasena());
		
		UsuarioModel usuarioActualizado = usuarioRepositorio.save(usuario);
		
		return mapearDTO(usuarioActualizado);
		
	}

	
}
