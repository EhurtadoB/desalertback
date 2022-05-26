package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desalert_back.models.AcudienteModel;
import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.models.MedicoModel;
import com.example.desalert_back.repositories.AcudienteRepository;
import com.example.desalert_back.repositories.InfanteRepository;
import com.example.desalert_back.repositories.MedicoRepository;
import com.example.desalert_back.dto.InfanteDTO;
import com.example.desalert_back.excepciones.ControlAppException;
import com.example.desalert_back.excepciones.ResourceNotFoundException;

@Service
public class InfanteServiceImpl implements InfanteService{
	
	@Autowired
	private InfanteRepository infanteRepository;
	
	@Autowired
	private AcudienteRepository acudienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepositorio;
	
	@Override
	public InfanteDTO crearInfante(long idMedico, long acudienteId, InfanteDTO infanteDTO) {
		InfanteModel infante = mapearEntidad(infanteDTO);
		
		MedicoModel medico = medicoRepositorio.findById(idMedico)
					.orElseThrow(()-> new ResourceNotFoundException("MedicoModel", "id", idMedico));
		
		AcudienteModel acudiente = acudienteRepository.findById(acudienteId)
					.orElseThrow(() -> new ResourceNotFoundException("AcudienteModel", "id", acudienteId));
		infante.setAcudiente(acudiente);
		infante.setMedico(medico);
		
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

		@Override
		public List<InfanteDTO> obtenerInfantePorMedico(long medicoId) {
			List<InfanteModel> infantes = infanteRepository.findByMedicoId(medicoId);
			return infantes.stream().map(infante -> mapearDTO(infante)).collect(Collectors.toList());
		}

		@Override
		public InfanteDTO obtenerInfantePorId(Long medicoId, Long infanteId) {
			MedicoModel medico = medicoRepositorio.findById(medicoId)
					.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
			
			InfanteModel infante = infanteRepository.findById(infanteId)
					.orElseThrow(() -> new ResourceNotFoundException("Infante", "id", infanteId));
			
			if(!infante.getMedico().getId().equals(medico.getId())) {
				throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Infante no pertenece al medico");
			}
			
			return mapearDTO(infante);
		}

		@Override
		public InfanteDTO actualizarInfante(Long medicoId, Long infanteId, InfanteDTO solicitudDeInfante) {
			MedicoModel medico = medicoRepositorio.findById(medicoId)
					.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
			
			InfanteModel infante = infanteRepository.findById(infanteId)
					.orElseThrow(() -> new ResourceNotFoundException("Infante", "id", infanteId));
			
			if(!infante.getMedico().getId().equals(medico.getId())) {
				throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Infante no pertenece al medico");
			}
			
			infante.setNombre(solicitudDeInfante.getNombre());
			infante.setDireccion(solicitudDeInfante.getDireccion());
			infante.setFechaNacimiento(solicitudDeInfante.getFechaNacimiento());
			infante.setSexo(solicitudDeInfante.getSexo());
			infante.setUrlImg(solicitudDeInfante.getUrlImg());
			
			InfanteModel infanteActualizado = infanteRepository.save(infante);
			
			return mapearDTO(infanteActualizado);
		}

		@Override
		public void eliminarInfante(Long medicoId, Long infanteId) {
			MedicoModel medico = medicoRepositorio.findById(medicoId)
					.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
			
			InfanteModel infante = infanteRepository.findById(infanteId)
					.orElseThrow(() -> new ResourceNotFoundException("Infante", "id", infanteId));
			
			if(!infante.getMedico().getId().equals(medico.getId())) {
				throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Infante no pertenece al medico");
			}
			
			infanteRepository.delete(infante);
		}

}
