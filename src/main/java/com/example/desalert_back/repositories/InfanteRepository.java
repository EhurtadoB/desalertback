package com.example.desalert_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desalert_back.models.InfanteModel;

@Repository
public interface InfanteRepository extends JpaRepository<InfanteModel, Long>{
	
	public List<InfanteModel> findByAcudienteId(long acudienteId);
	public List<InfanteModel> findByMedicoId(long medicoId);
}
