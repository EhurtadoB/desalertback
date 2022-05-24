package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.ImcModel;
import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.repositories.ImcRepository;
import com.example.desalert_back.repositories.InfanteRepository;

import com.example.desalert_back.dto.ImcDTO;
import com.example.desalert_back.excepciones.ResourceNotFoundException;

@Service
public class ImcServiceImpl implements ImcService{
	
	@Autowired
	private ImcRepository imcRepository;
	
	@Autowired
	private InfanteRepository infanteRepository;

	@Override
	public ImcDTO crearImc(long infanteId, ImcDTO imcDTO) {
		
		ImcModel imc = mapearEntidad(imcDTO);
		InfanteModel infante = infanteRepository.findById(infanteId)
					.orElseThrow(() -> new ResourceNotFoundException("InfanteModel", "id", infanteId));
		imc.setInfante(infante);
	
		ImcModel imcNuevo = imcRepository.save(imc);
		return mapearDTO(imcNuevo);
	}

	@Override
	public List<ImcDTO> obtenerImcPorInfanteId(long infanteId) {
		List<ImcModel> imcs = imcRepository.findByInfanteId(infanteId);
		return imcs.stream().map(imc -> mapearDTO(imc)).collect(Collectors.toList());
	}
	
	//convertir entidad a DTO
			private ImcDTO mapearDTO(ImcModel imc) {
				ImcDTO imcDTO = new ImcDTO();
				imcDTO.setId(imc.getId());
				imcDTO.setImc(imc.getImc());
				
				return imcDTO;
			}
			
			
			//convierte de DTO a entidad
			private ImcModel mapearEntidad(ImcDTO imcDTO) {
				ImcModel imc = new ImcModel();
				imc.setId(imcDTO.getId());
				imc.setImc(imcDTO.getImc());
				
				return imc;
			}

}
