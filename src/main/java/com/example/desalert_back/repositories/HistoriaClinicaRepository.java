package com.example.desalert_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.desalert_back.models.HistoriaClinicaModel;


@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinicaModel, Long> {
	public List<HistoriaClinicaModel> findByInfanteId(long infanteId);
}
