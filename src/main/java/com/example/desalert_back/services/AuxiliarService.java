package com.example.desalert_back.services;

import java.util.List;

import dto.AuxiliarDTO;

public interface AuxiliarService {
	
	public AuxiliarDTO crearAuxiliar(AuxiliarDTO auxiliarDTO);
    public List<AuxiliarDTO> obtenerTodosLosAuxiliares();
    public AuxiliarDTO obtenerAuxiliarPorId(long id);
    public AuxiliarDTO actualizarAuxiliar(AuxiliarDTO axiliarDTO, long id);

}
