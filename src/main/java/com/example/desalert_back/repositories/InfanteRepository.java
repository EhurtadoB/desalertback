package com.example.desalert_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desalert_back.models.InfanteModel;

public interface InfanteRepository extends JpaRepository<InfanteModel, Long>{
	public List<InfanteModel> findByMedicoId(long medicoId);
}
