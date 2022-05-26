package com.example.desalert_back.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desalert_back.models.RolesModel;

public interface RolRepository extends JpaRepository<RolesModel, Long>{
	
	public Optional<RolesModel> findByNombre(String nombre);
	
}