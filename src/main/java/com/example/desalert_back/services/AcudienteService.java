package com.example.desalert_back.services;


import java.util.List;

import dto.AcudienteDTO;


public interface AcudienteService {
    public AcudienteDTO crearAcudiente(AcudienteDTO acudienteDTO);
    public List<AcudienteDTO> obtenerTodosLosAcudientes();
    public AcudienteDTO obtenerAcudientePorId(long id);
    public AcudienteDTO actualizarAcudiente(AcudienteDTO acudienteDTO, long id);

}
