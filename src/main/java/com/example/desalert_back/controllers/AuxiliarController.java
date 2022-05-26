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

import com.example.desalert_back.services.AuxiliarService;

import com.example.desalert_back.dto.AuxiliarDTO;

@RestController
@RequestMapping("/api/")
public class AuxiliarController {
	
	@Autowired
    private AuxiliarService auxiliarService;
	
	@GetMapping("/personas/auxiliar")
	    public List<AuxiliarDTO> listarAuxiliares(){
	        return this.auxiliarService.obtenerTodosLosAuxiliares();
	}
	
	@GetMapping("/personas/auxiliar/{id}")
    public ResponseEntity<AuxiliarDTO> obtenerAuxiliaresPorId(@PathVariable(name="id") long id){
    	return ResponseEntity.ok(auxiliarService.obtenerAuxiliarPorId(id));
    }
	
    @PostMapping("/personas/auxiliar")
    public ResponseEntity<AuxiliarDTO> guardarAuxiliar(@RequestBody AuxiliarDTO auxiliarDTO){
    	return new ResponseEntity<>(auxiliarService.crearAuxiliar(auxiliarDTO), HttpStatus.CREATED);
    }

    
    @PutMapping("/personas/auxiliar/{id}")
    public ResponseEntity<AuxiliarDTO> actualizarAuxiliares(@RequestBody AuxiliarDTO auxiliarDTO, @PathVariable(name="id") long id){
    	AuxiliarDTO auxiliarRespuesta = auxiliarService.actualizarAuxiliar(auxiliarDTO, id);
    	return new ResponseEntity<>(auxiliarRespuesta, HttpStatus.OK);
    }

}
