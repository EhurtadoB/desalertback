package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.AcudienteModel;
import com.example.desalert_back.repositories.AcudienteRepository;

import dto.AcudienteDTO;
import excepciones.ResourceNotFoundException;

@Service
public class AcudienteServiceImpl implements AcudienteService{
	@Autowired
	private AcudienteRepository acudienteRepository;
	
	@Override
	public AcudienteDTO crearAcudiente(dto.AcudienteDTO acudienteDTO) {
		// convertimos de DTO a entidad
		AcudienteModel acudiente = mapearEntidad(acudienteDTO);
		AcudienteModel nuevoAcudiente = acudienteRepository.save(acudiente);
		
		//convertimos de entidad a DTO
		AcudienteDTO acudienteRespuesta = mapearDTO(nuevoAcudiente);
		return acudienteRespuesta;
	}

	@Override
	public List<AcudienteDTO> obtenerTodosLosAcudientes() {
		List<AcudienteModel> acudientes= acudienteRepository.findAll();
		
		return acudientes.stream().map(acudiente ->mapearDTO(acudiente)).collect(Collectors.toList());
	}
	
	//convertir entidad a DTO
	private AcudienteDTO mapearDTO(AcudienteModel acudiente) {
		AcudienteDTO acudienteDTO = new AcudienteDTO();
		acudienteDTO.setId(acudiente.getId());
		acudienteDTO.setNombre(acudiente.getNombre());
		acudienteDTO.setDireccion(acudiente.getDireccion());
		acudienteDTO.setFechaNacimiento(acudiente.getFechaNacimiento());
		acudienteDTO.setSexo(acudiente.getSexo());
		acudienteDTO.setTelefono(acudiente.getTelefono());
		acudienteDTO.setParentesco(acudiente.getParentesco());
		
		return acudienteDTO;
	}
	
	
	//convierte de DTO a entidad
	private AcudienteModel mapearEntidad(AcudienteDTO acudienteDTO) {
		AcudienteModel acudiente = new AcudienteModel();
		acudiente.setId(acudienteDTO.getId());
		acudiente.setNombre(acudienteDTO.getNombre());
		acudiente.setDireccion(acudienteDTO.getDireccion());
		acudiente.setFechaNacimiento(acudienteDTO.getFechaNacimiento());
		acudiente.setSexo(acudienteDTO.getSexo());
		acudiente.setTelefono(acudienteDTO.getTelefono());
		acudiente.setParentesco(acudienteDTO.getParentesco());
		
		return acudiente;
	}

	@Override
	public AcudienteDTO obtenerAcudientePorId(long id) {
		AcudienteModel acudiente = acudienteRepository
				.findById(id).orElseThrow(()->new ResourceNotFoundException("AcudienteModel", "id", id));
		return mapearDTO(acudiente);
	}

	@Override
	public AcudienteDTO actualizarAcudiente(AcudienteDTO acudienteDTO, long id) {
		AcudienteModel acudiente = acudienteRepository
				.findById(id).orElseThrow(()->new ResourceNotFoundException("AcudienteModel", "id", id));
		acudiente.setId(acudienteDTO.getId());
		acudiente.setNombre(acudienteDTO.getNombre());
		acudiente.setDireccion(acudienteDTO.getDireccion());
		acudiente.setFechaNacimiento(acudienteDTO.getFechaNacimiento());
		acudiente.setSexo(acudienteDTO.getSexo());
		acudiente.setTelefono(acudienteDTO.getTelefono());
		acudiente.setParentesco(acudienteDTO.getParentesco());
		
		AcudienteModel acudienteActualizado = acudienteRepository.save(acudiente);
		return mapearDTO(acudienteActualizado);
	}
	
	
	
}
