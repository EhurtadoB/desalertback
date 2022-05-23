package com.example.desalert_back.repositories;

import com.example.desalert_back.models.UsuarioModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	public abstract ArrayList<UsuarioModel> findByCargo(String cargo);

	
}
