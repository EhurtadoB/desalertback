package com.example.desalert_back.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.dto.HistoriaClinicaDTO;
import com.example.desalert_back.services.HistoriaClinicaService;

@RestController
@RequestMapping("/api/")
public class HistoriaClinicaController {
	@Autowired
	HistoriaClinicaService historiaServicio;
	
	@GetMapping("/infantes/{infanteId}/historias")
	public List<HistoriaClinicaDTO> listarHistoriasPorInfante(@PathVariable(name="infanteId") long infanteId){
		return historiaServicio.obtenerHistoriaPorInfante(infanteId);
	}
	
	@GetMapping("/infantes/{infanteId}/historias/{id}")
	public ResponseEntity<HistoriaClinicaDTO> obtenerHistoriaPorId(@PathVariable(name="infanteId") Long infanteId, @PathVariable(name="id") Long historiaId){
		HistoriaClinicaDTO historiaDTO = historiaServicio.obtenerHistoriaPorId(infanteId, historiaId);
		
		return new ResponseEntity<>(historiaDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/infantes/{infanteId}/historias")
	public ResponseEntity<HistoriaClinicaDTO> guardarHistoriaClinica(@PathVariable(name="infanteId") long infanteId, @RequestBody HistoriaClinicaDTO historiaDTO){
		return new ResponseEntity<>(historiaServicio.crearHistoria(infanteId, historiaDTO), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/infantes/{infanteId}/historias/{id}")
	public ResponseEntity<HistoriaClinicaDTO> actualizarHistoria(@PathVariable(name="infanteId") Long infanteId, @PathVariable(name="id") Long historiaId, @RequestBody HistoriaClinicaDTO historiaDTO){
		HistoriaClinicaDTO historiaActualizada = historiaServicio.actualizarHistoria(infanteId, historiaId, historiaDTO);
		return new ResponseEntity<>(historiaActualizada, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/infantes/{infanteId}/historias/{id}")
	public ResponseEntity<String> eliminarHistoria(@PathVariable(name="infanteId") Long infanteId, @PathVariable(name="id") Long historiaId){
		historiaServicio.eliminarHistoria(infanteId, historiaId);
		return new ResponseEntity<>("Historia Clinica eliminada con exito", HttpStatus.OK);
	}
	
}