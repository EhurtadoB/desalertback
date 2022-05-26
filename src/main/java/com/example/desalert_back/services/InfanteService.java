package com.example.desalert_back.services;



import java.util.List;

import com.example.desalert_back.dto.InfanteDTO;


public interface InfanteService {
	
	public InfanteDTO crearInfante(long idMedico, long acudienteId, InfanteDTO infante);
	public List<InfanteDTO> obtenerInfantePorMedico(long medicoId);
	public InfanteDTO obtenerInfantePorId(Long medicoId, Long infanteId);
	public InfanteDTO actualizarInfante(Long medicoId, Long infanteId, InfanteDTO solicitudDeInfante);
	public void eliminarInfante(Long medicoId, Long infanteId);
	
	public List<InfanteDTO> obtenerInfantesPorAcudienteId(long acudienteId);
}
