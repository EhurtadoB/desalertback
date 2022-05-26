package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desalert_back.dto.MedicoDTO;
import com.example.desalert_back.excepciones.ResourceNotFoundException;
import com.example.desalert_back.models.MedicoModel;
import com.example.desalert_back.repositories.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	MedicoRepository medicoRepositorio;

	@Override
	public MedicoDTO crearMedico(MedicoDTO medicoDTO) {
		MedicoModel medico = mapearEntidad(medicoDTO);

		MedicoModel nuevoMedico = medicoRepositorio.save(medico);

		MedicoDTO medicoRespuesta = mapearDTO(nuevoMedico);

		return medicoRespuesta;
	}

	// convertir a DTO
	public MedicoDTO mapearDTO(MedicoModel medico) {
		MedicoDTO medicoDTO = new MedicoDTO();

		medicoDTO.setId(medico.getId());
		medicoDTO.setNombre(medico.getNombre());
		medicoDTO.setDireccion(medico.getDireccion());
		medicoDTO.setFechaNacimiento(medico.getFechaNacimiento());
		medicoDTO.setSexo(medico.getSexo());
		medicoDTO.setTelefono(medico.getTelefono());
		medicoDTO.setEspecialidad(medico.getEspecialidad());

		return medicoDTO;
	}

	// convertir a Entidad
	public MedicoModel mapearEntidad(MedicoDTO medicoDTO) {
		MedicoModel medico = new MedicoModel();

		medico.setId(medicoDTO.getId());
		medico.setNombre(medicoDTO.getNombre());
		medico.setDireccion(medicoDTO.getDireccion());
		medico.setFechaNacimiento(medicoDTO.getFechaNacimiento());
		medico.setSexo(medicoDTO.getSexo());
		medico.setTelefono(medicoDTO.getTelefono());
		medico.setEspecialidad(medicoDTO.getEspecialidad());

		return medico;
	}

	@Override
	public List<MedicoDTO> obtenerTodosMedicos() {
		List<MedicoModel> medicos = medicoRepositorio.findAll();

		return medicos.stream().map(medico -> mapearDTO(medico)).collect(Collectors.toList());
	}

	@Override
	public MedicoDTO obtenerMedicoPorId(long id) {
		MedicoModel medico = medicoRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medico", "id", id));
		return mapearDTO(medico);
	}

}
