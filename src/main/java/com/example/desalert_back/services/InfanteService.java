package com.example.desalert_back.services;



import java.util.List;

import com.example.desalert_back.dto.InfanteDTO;


public interface InfanteService {
	
	public InfanteDTO crearInfante(long acudienteId, InfanteDTO infante);	
	public List<InfanteDTO> obtenerInfantesPorAcudienteId(long acudienteId);
}
