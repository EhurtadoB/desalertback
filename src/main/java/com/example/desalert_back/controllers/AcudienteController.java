package com.example.desalert_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.services.AcudienteService;

import dto.AcudienteDTO;

@RestController
@RequestMapping("/api/acudiente")
public class AcudienteController {
	@Autowired
    private AcudienteService acudienteService;
	
	@GetMapping
	    public List<AcudienteDTO> listarAcudientes(){
	        return this.acudienteService.obtenerTodosLosAcudientes();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<AcudienteDTO> obtenerAcudientePorId(@PathVariable(name="id") long id){
    	return ResponseEntity.ok(acudienteService.obtenerAcudientePorId(id));
    }
	
    @PostMapping()
    public ResponseEntity<AcudienteDTO> guardarAcudiente(@RequestBody AcudienteDTO acudienteDTO){
    	return new ResponseEntity<>(acudienteService.crearAcudiente(acudienteDTO), HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<AcudienteDTO> actualizarAcudientes(@RequestBody AcudienteDTO acudienteDTO, @PathVariable(name="id") long id){
    	AcudienteDTO acudienteRespuesta = acudienteService.actualizarAcudiente(acudienteDTO, id);
    	return new ResponseEntity<>(acudienteRespuesta, HttpStatus.OK);
    }
    
}
