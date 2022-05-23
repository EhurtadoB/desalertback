package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.AuxiliarModel;
import com.example.desalert_back.repositories.AuxiliarRepository;

import dto.AuxiliarDTO;
import excepciones.ResourceNotFoundException;

@Service
public class AuxiliarServiceImpl implements AuxiliarService {
	
	@Autowired
	private AuxiliarRepository auxiliarRepository;
	
	@Override
	public AuxiliarDTO crearAuxiliar(AuxiliarDTO auxiliarDTO) {
		//convertimos de DTO a entidad 
		AuxiliarModel auxiliar = mapearEntidad(auxiliarDTO);
		AuxiliarModel nuevoAuxiliar = auxiliarRepository.save(auxiliar);
		
		//convertimos de entidad a DTO
		AuxiliarDTO auxiliarRespuesta = mapearDTO(nuevoAuxiliar);
		
		return auxiliarRespuesta;
		
	}

	@Override
	public List<AuxiliarDTO> obtenerTodosLosAuxiliares() {
		List<AuxiliarModel> auxiliares = auxiliarRepository.findAll();
		return auxiliares.stream().map(auxiliar -> mapearDTO(auxiliar)).collect(Collectors.toList());
		
	}

	@Override
	public AuxiliarDTO obtenerAuxiliarPorId(long id) {
		AuxiliarModel auxiliar = auxiliarRepository
				.findById(id).orElseThrow(()->new ResourceNotFoundException("AuxiliarModel", "id", id));
		
		return mapearDTO (auxiliar);
		
	}

	@Override
	public AuxiliarDTO actualizarAuxiliar(AuxiliarDTO auxiliarDTO, long id) {
		
		AuxiliarModel auxiliar = auxiliarRepository
				.findById(id).orElseThrow(()->new ResourceNotFoundException("AuxiliarModel", "id", id));
		auxiliar.setId(auxiliarDTO.getId());
		auxiliar.setNombre(auxiliarDTO.getNombre());
		auxiliar.setDireccion(auxiliarDTO.getDireccion());
		auxiliar.setFechaNacimiento(auxiliarDTO.getFechaNacimiento());
		auxiliar.setSexo(auxiliarDTO.getSexo());
		auxiliar.setTelefono(auxiliarDTO.getTelefono());
		AuxiliarModel auxiliarActualizado = auxiliarRepository.save(auxiliar);
		
		return mapearDTO(auxiliarActualizado);
	}
	
	//convertir entidad a DTO
	private AuxiliarDTO mapearDTO(AuxiliarModel auxiliar) {
		AuxiliarDTO auxiliarDTO = new AuxiliarDTO();
		auxiliarDTO.setId(auxiliar.getId());
		auxiliarDTO.setNombre(auxiliar.getNombre());
		auxiliarDTO.setDireccion(auxiliar.getDireccion());
		auxiliarDTO.setFechaNacimiento(auxiliar.getFechaNacimiento());
		auxiliarDTO.setSexo(auxiliar.getSexo());
		auxiliarDTO.setTelefono(auxiliar.getTelefono());
		
		return auxiliarDTO;
		
	}
	
	//convierte de DTO a entidad
	private AuxiliarModel mapearEntidad(AuxiliarDTO auxiliarDTO) {
		AuxiliarModel auxiliar = new AuxiliarModel();
		auxiliar.setId(auxiliarDTO.getId());
		auxiliar.setNombre(auxiliarDTO.getNombre());
		auxiliar.setDireccion(auxiliarDTO.getDireccion());
		auxiliar.setFechaNacimiento(auxiliarDTO.getFechaNacimiento());
		auxiliar.setSexo(auxiliarDTO.getSexo());
		auxiliar.setTelefono(auxiliarDTO.getTelefono());
		
		return auxiliar;
	}
	

}
