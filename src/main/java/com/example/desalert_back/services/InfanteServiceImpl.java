package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.AcudienteModel;
import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.repositories.AcudienteRepository;
import com.example.desalert_back.repositories.InfanteRepository;

import dto.InfanteDTO;
import excepciones.ResourceNotFoundException;

@Service
public class InfanteServiceImpl implements InfanteService{
	
	@Autowired
	private InfanteRepository infanteRepository;
	
	@Autowired
	private AcudienteRepository acudienteRepository;
	
	@Override
	public InfanteDTO crearInfante(long acudienteId, InfanteDTO infanteDTO) {
		InfanteModel infante = mapearEntidad(infanteDTO);
		
		
		AcudienteModel acudiente = acudienteRepository.findById(acudienteId)
					.orElseThrow(() -> new ResourceNotFoundException("AcudienteModel", "id", acudienteId));
		infante.setAcudiente(acudiente);
	
		InfanteModel infanteNuevo = infanteRepository.save(infante);
		return mapearDTO(infanteNuevo);
	}
	
	//convertir entidad a DTO
		private InfanteDTO mapearDTO(InfanteModel infante) {
			InfanteDTO infanteDTO = new InfanteDTO();
			infanteDTO.setId(infante.getId());
			infanteDTO.setNombre(infante.getNombre());
			infanteDTO.setDireccion(infante.getDireccion());
			infanteDTO.setFechaNacimiento(infante.getFechaNacimiento());
			infanteDTO.setSexo(infante.getSexo());
			infanteDTO.setUrlImg(infante.getUrlImg());
			
			return infanteDTO;
		}
		
		
		//convierte de DTO a entidad
		private InfanteModel mapearEntidad(InfanteDTO infanteDTO) {
			InfanteModel infante = new InfanteModel();
			infante.setId(infanteDTO.getId());
			infante.setNombre(infanteDTO.getNombre());
			infante.setDireccion(infanteDTO.getDireccion());
			infante.setFechaNacimiento(infanteDTO.getFechaNacimiento());
			infante.setSexo(infanteDTO.getSexo());
			infante.setUrlImg(infanteDTO.getUrlImg());
			
			return infante;
		}

		@Override
		public List<InfanteDTO> obtenerInfantesPorAcudienteId(long acudienteId) {
			List<InfanteModel> infantes = infanteRepository.findByAcudienteId(acudienteId);
		
			return infantes.stream().map(infante -> mapearDTO(infante)).collect(Collectors.toList());
		}

}
