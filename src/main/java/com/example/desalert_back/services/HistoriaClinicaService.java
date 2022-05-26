package com.example.desalert_back.services;

import java.util.List;

import com.example.desalert_back.dto.HistoriaClinicaDTO;

public interface HistoriaClinicaService {
	public HistoriaClinicaDTO crearHistoria(long infanteId, HistoriaClinicaDTO historiaDTO);
	
	public List<HistoriaClinicaDTO> obtenerHistoriaPorInfante(long infanteId);
	
	public HistoriaClinicaDTO obtenerHistoriaPorId(Long infanteId, Long historiaId);
	
	public HistoriaClinicaDTO actualizarHistoria(Long infanteId, Long historiaId, HistoriaClinicaDTO solicitudDeHistoria);

	public void eliminarHistoria(Long infanteId, Long historiaId);
	
}