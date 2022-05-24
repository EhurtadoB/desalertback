package com.example.desalert_back.controllers;

import com.example.desalert_back.dto.MedicoDTO;
import com.example.desalert_back.services.MedicoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class MedicoController {
    @Autowired
    MedicoService medicoServicio;

    @GetMapping("/medicos")
    public List<MedicoDTO> listarMedicos(){
    	return medicoServicio.obtenerTodosMedicos();
    }
    
    @GetMapping("/medicos/{id}")
    public ResponseEntity<MedicoDTO> obtenerMedicoPorId(@PathVariable(name = "id") long id){
    	return ResponseEntity.ok(medicoServicio.obtenerMedicoPorId(id));
    }
    
    
    @PostMapping("/medicos")
    public ResponseEntity<MedicoDTO> guardarMedico(@RequestBody MedicoDTO medicoDTO){
    	return new ResponseEntity<>(medicoServicio.crearMedico(medicoDTO), HttpStatus.CREATED);
    }
    
}
