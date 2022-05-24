package com.example.desalert_back.services;

import java.util.List;

import com.example.desalert_back.dto.ImcDTO;

public interface ImcService {
	public ImcDTO crearImc(long infanteId, ImcDTO imc);	
	public List<ImcDTO> obtenerImcPorInfanteId(long infanteId);
}
