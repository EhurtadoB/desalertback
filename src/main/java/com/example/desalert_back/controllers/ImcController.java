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

import com.example.desalert_back.services.ImcService;

import com.example.desalert_back.dto.ImcDTO;

@RestController
@RequestMapping("/api/")
public class ImcController {
	@Autowired
	private ImcService imcService;
	
	@GetMapping("/infantes/{infanteId}/imc")
	public List<ImcDTO> ListarImcPorInfanteId(@PathVariable(value="infanteId") long infanteID){
		return imcService.obtenerImcPorInfanteId(infanteID);
		
	}
	
	@PostMapping("/infantes/{infanteId}/imc")
	public ResponseEntity<ImcDTO> guardarImc(@PathVariable(value="infanteId") long infanteId, @RequestBody ImcDTO imcDto){
		return new ResponseEntity<>(imcService.crearImc(infanteId, imcDto), HttpStatus.CREATED);
	}

}
