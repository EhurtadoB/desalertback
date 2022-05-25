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

import com.example.desalert_back.dto.InfanteDTO;
import com.example.desalert_back.services.InfanteService;


@RestController
@RequestMapping("/api/")
public class InfanteController {
	@Autowired
    InfanteService infanteServicio;
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/medicos/{idMedico}/infantes")
    public ResponseEntity<InfanteDTO> guardarInfante(@PathVariable(name="idMedico") long idMedico,@RequestBody InfanteDTO infanteDTO){
    	return new ResponseEntity<>(infanteServicio.crearInfante(idMedico, infanteDTO), HttpStatus.CREATED); 
    }
    
    @GetMapping("/medicos/{idMedico}/infantes")
    public List<InfanteDTO> listarInfantesPorMedico(@PathVariable(name= "idMedico") long idMedico){
    	return infanteServicio.obtenerInfantePorMedico(idMedico);
    }
    
    @GetMapping("/medicos/{idMedico}/infantes/{id}")
    public ResponseEntity<InfanteDTO> obtenerInfantePorId(@PathVariable(name = "idMedico") long idMedico, @PathVariable(name = "id") long idInfante){
    	
    	InfanteDTO infanteDTO = infanteServicio.obtenerInfantePorId(idMedico, idInfante);
    	
    	return new ResponseEntity<>(infanteDTO, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/medicos/{idMedico}/infantes/{id}")
	public ResponseEntity<InfanteDTO> actualizarInfante(@PathVariable(name="idMedico") Long medicoId, @PathVariable(name="id") Long infanteId, @RequestBody InfanteDTO infanteDTO){
		InfanteDTO infanteActualizado = infanteServicio.actualizarInfante(medicoId, infanteId, infanteDTO);
		return new ResponseEntity<>(infanteActualizado, HttpStatus.OK);
	}
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/medicos/{idMedico}/infantes/{id}")
	public ResponseEntity<String> eliminarInfante(@PathVariable(name="idMedico") Long medicoId, @PathVariable(name="id") Long infanteId){
		infanteServicio.eliminarInfante(medicoId, infanteId);
		return new ResponseEntity<>("Historia Clinica eliminada con exito", HttpStatus.OK);
	}

}
