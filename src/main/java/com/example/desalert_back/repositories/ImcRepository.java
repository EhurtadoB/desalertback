package com.example.desalert_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desalert_back.models.ImcModel;

@Repository
public interface ImcRepository extends JpaRepository<ImcModel, Long>{
	public List<ImcModel> findByInfanteId(long infanteId);
}
