package com.example.desalert_back.services;

import java.util.List;

import com.example.desalert_back.dto.MedicoDTO;

public interface MedicoService {
	
	public MedicoDTO crearMedico(MedicoDTO medicoDTO);
	
	public List<MedicoDTO> obtenerTodosMedicos();
	
	public MedicoDTO obtenerMedicoPorId(long id);
    

}
