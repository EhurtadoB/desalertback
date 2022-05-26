package com.example.desalert_back.repositories;

import com.example.desalert_back.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	public Optional<UsuarioModel> findByEmail(String email);
	
	public Boolean existsByEmail(String email);
	
	public List<UsuarioModel> findByPersonaId(long personaId);
}
