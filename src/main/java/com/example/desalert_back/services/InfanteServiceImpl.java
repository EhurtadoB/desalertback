package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desalert_back.dto.InfanteDTO;
import com.example.desalert_back.excepciones.ControlAppException;
import com.example.desalert_back.excepciones.ResourceNotFoundException;
import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.models.MedicoModel;
import com.example.desalert_back.repositories.InfanteRepository;
import com.example.desalert_back.repositories.MedicoRepository;

@Service
public class InfanteServiceImpl implements InfanteService {

	@Autowired
	private InfanteRepository infanteRepositorio;

	@Autowired
	private MedicoRepository medicoRepositorio; 
	
	@Override
	public InfanteDTO crearInfante(long medicoId, InfanteDTO infanteDTO) {
		// Covertimos DTO a entidad
		InfanteModel infante = mapearEntidad(infanteDTO);
		MedicoModel medico = medicoRepositorio.findById(medicoId)
				.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));

		infante.setMedico(medico);

		InfanteModel nuevoInfante = infanteRepositorio.save(infante);

		return mapearDTO(nuevoInfante);
	}

	// convertir a DTO
	private InfanteDTO mapearDTO(InfanteModel infante) {
		InfanteDTO infanteDTO = new InfanteDTO();

		infanteDTO.setId(infante.getId());
		infanteDTO.setNombre(infante.getNombre());
		infanteDTO.setDireccion(infante.getDireccion());
		infanteDTO.setFechaNacimiento(infante.getFechaNacimiento());
		infanteDTO.setSexo(infante.getSexo());
		infanteDTO.setTelefono(infante.getTelefono());
		infanteDTO.setUrlImg(infante.getUrlImg());

		return infanteDTO;
	}

	// convertir a Entidad
	private InfanteModel mapearEntidad(InfanteDTO infanteDTO) {
		InfanteModel infante = new InfanteModel();

		infante.setId(infanteDTO.getId());
		infante.setNombre(infanteDTO.getNombre());
		infante.setDireccion(infanteDTO.getDireccion());
		infante.setFechaNacimiento(infanteDTO.getFechaNacimiento());
		infante.setSexo(infanteDTO.getSexo());
		infante.setTelefono(infanteDTO.getTelefono());
		infante.setUrlImg(infanteDTO.getUrlImg());

		return infante;
	}

	@Override
	public InfanteDTO obtenerInfantePorId(Long medicoId, Long infanteId) {
		MedicoModel medico = medicoRepositorio.findById(medicoId)
				.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
		
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(() -> new ResourceNotFoundException("Infante", "id", infanteId));
		
		if(!infante.getMedico().getId().equals(medico.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Infante no pertenece al medico");
		}
		
		return mapearDTO(infante);
	}

	@Override
	public List<InfanteDTO> obtenerInfantePorMedico(long medicoId) {
		List<InfanteModel> infantes = infanteRepositorio.findByMedicoId(medicoId);
		return infantes.stream().map(infante -> mapearDTO(infante)).collect(Collectors.toList());
	}

	@Override
	public InfanteDTO actualizarInfante(Long medicoId, Long infanteId, InfanteDTO solicitudDeInfante) {
		MedicoModel medico = medicoRepositorio.findById(medicoId)
				.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
		
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(() -> new ResourceNotFoundException("Infante", "id", infanteId));
		
		if(!infante.getMedico().getId().equals(medico.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Infante no pertenece al medico");
		}
		
		infante.setNombre(solicitudDeInfante.getNombre());
		infante.setDireccion(solicitudDeInfante.getDireccion());
		infante.setFechaNacimiento(solicitudDeInfante.getFechaNacimiento());
		infante.setSexo(solicitudDeInfante.getSexo());
		infante.setTelefono(solicitudDeInfante.getTelefono());
		infante.setUrlImg(solicitudDeInfante.getUrlImg());
		
		InfanteModel infanteActualizado = infanteRepositorio.save(infante);
		
		return mapearDTO(infanteActualizado);
		
	}

	@Override
	public void eliminarInfante(Long medicoId, Long infanteId) {
		MedicoModel medico = medicoRepositorio.findById(medicoId)
				.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
		
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(() -> new ResourceNotFoundException("Infante", "id", infanteId));
		
		if(!infante.getMedico().getId().equals(medico.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "El Infante no pertenece al medico");
		}
		
		infanteRepositorio.delete(infante);
		
	}

}
