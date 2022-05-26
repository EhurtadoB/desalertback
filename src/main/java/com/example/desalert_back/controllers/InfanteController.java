package com.example.desalert_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desalert_back.services.InfanteService;

import com.example.desalert_back.dto.InfanteDTO;

@RestController
@RequestMapping("/api/")
public class InfanteController {

	@Autowired
	private InfanteService infanteService;

	@GetMapping("/acudientes/{acudienteId}/infante")
	public List<InfanteDTO> listarInfantesPorAcudientesId(@PathVariable(value = "acudienteId") long acudienteID) {
		return infanteService.obtenerInfantesPorAcudienteId(acudienteID);

	}

	@GetMapping("/medicos/{idMedico}/infantes")
	public List<InfanteDTO> listarInfantesPorMedico(@PathVariable(name = "idMedico") long idMedico) {
		return infanteService.obtenerInfantePorMedico(idMedico);
	}

	@GetMapping("/medicos/{idMedico}/infantes/{id}")
	public ResponseEntity<InfanteDTO> obtenerInfantePorId(@PathVariable(name = "idMedico") long idMedico,
			@PathVariable(name = "id") long idInfante) {

		InfanteDTO infanteDTO = infanteService.obtenerInfantePorId(idMedico, idInfante);

		return new ResponseEntity<>(infanteDTO, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("medicos/{idMedico}/acudientes/{acudienteId}/infante")
	public ResponseEntity<InfanteDTO> guardarInfante(@PathVariable(value = "idMedico") long idMedico,
			@PathVariable(value = "acudienteId") long acudienteID, @RequestBody InfanteDTO infanteDto) {
		return new ResponseEntity<>(infanteService.crearInfante(idMedico, acudienteID, infanteDto), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/medicos/{idMedico}/acudientes/{acudienteId}/infante/{id}")
	public ResponseEntity<InfanteDTO> actualizarInfante(@PathVariable(name = "idMedico") Long medicoId,
			@PathVariable(name = "id") Long infanteId, @RequestBody InfanteDTO infanteDTO) {
		InfanteDTO infanteActualizado = infanteService.actualizarInfante(medicoId, infanteId, infanteDTO);
		return new ResponseEntity<>(infanteActualizado, HttpStatus.OK);
	}

}
