package com.example.desalert_back.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.services.InfanteService;

import dto.InfanteDTO;

@RestController
@RequestMapping("/api/")
public class InfanteController {
	
	@Autowired
	private InfanteService infanteService;
	
	@GetMapping("/acudientes/{acudienteId}/infante")
	public List<InfanteDTO> listarInfantesPorAcudientesId(@PathVariable(value="acudienteId") long acudienteID){
		return infanteService.obtenerInfantesPorAcudienteId(acudienteID);
		
	}
	
	@PostMapping("/acudientes/{acudienteId}/infante")
	public ResponseEntity<InfanteDTO> guardarInfante(@PathVariable(value="acudienteId") long acudienteID, @RequestBody InfanteDTO infanteDto){
		return new ResponseEntity<>(infanteService.crearInfante(acudienteID, infanteDto), HttpStatus.CREATED);
	}
	
}
