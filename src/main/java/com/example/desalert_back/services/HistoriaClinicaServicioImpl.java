package com.example.desalert_back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.desalert_back.dto.HistoriaClinicaDTO;
import com.example.desalert_back.excepciones.ControlAppException;
import com.example.desalert_back.excepciones.ResourceNotFoundException;
import com.example.desalert_back.models.HistoriaClinicaModel;
import com.example.desalert_back.models.InfanteModel;
import com.example.desalert_back.models.MedicoModel;
import com.example.desalert_back.repositories.HistoriaClinicaRepository;
import com.example.desalert_back.repositories.InfanteRepository;
import com.example.desalert_back.repositories.MedicoRepository;



@Service
public class HistoriaClinicaServicioImpl implements HistoriaClinicaService{

	@Autowired
	private HistoriaClinicaRepository historiaRepositorio;
	
	@Autowired
	private InfanteRepository infanteRepositorio;
	
	@Autowired
	private MedicoRepository medicoRepositorio;
	
	@Autowired
	private InfanteServiceImpl infanteServicio;
	
	@Autowired
	private MedicoServiceImpl medicoServicio;
	
	@Override
	public HistoriaClinicaDTO crearHistoria(long medicoId, long infanteId, HistoriaClinicaDTO historiaDTO) {
		HistoriaClinicaModel historia = mapearEntidad(historiaDTO);
		
		MedicoModel medico = medicoRepositorio.findById(medicoId)
				.orElseThrow(()->new ResourceNotFoundException("medico", "id", medicoId));
		
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(()->new ResourceNotFoundException("infante", "id", infanteId));
		
		historia.setInfante(infante);
		
		historia.setMedico(medico);
		
		HistoriaClinicaModel nuevaHistoria = historiaRepositorio.save(historia);
		
		return mapearDTO(nuevaHistoria);
	}
	
	private HistoriaClinicaDTO mapearDTO(HistoriaClinicaModel historia, MedicoModel medico, InfanteModel infante) {
		HistoriaClinicaDTO historiaDTO = new HistoriaClinicaDTO();
		
		historiaDTO.setId(historia.getId());
		historiaDTO.setAltura(historia.getAltura());
		historiaDTO.setPeso(historia.getPeso());
		historiaDTO.setPadecimientos(historia.getPadecimientos());
		historiaDTO.setDiagnosticoPrevio(historia.getDiagnosticoPrevio());
		
		historiaDTO.setInfanteDTO(infanteServicio.mapearDTO(infante));
		
		return historiaDTO;
		
	}
	
	private HistoriaClinicaDTO mapearDTO(HistoriaClinicaModel historia) {
		HistoriaClinicaDTO historiaDTO = new HistoriaClinicaDTO();
		
		historiaDTO.setId(historia.getId());
		historiaDTO.setAltura(historia.getAltura());
		historiaDTO.setPeso(historia.getPeso());
		historiaDTO.setPadecimientos(historia.getPadecimientos());
		historiaDTO.setDiagnosticoPrevio(historia.getDiagnosticoPrevio());
		historiaDTO.setInfanteDTO(infanteServicio.mapearDTO(historia.getInfante()));
		historiaDTO.setMedicoDTO(medicoServicio.mapearDTO(historia.getMedico()));
		
		return historiaDTO;
		
	}
	
	private HistoriaClinicaModel mapearEntidad(HistoriaClinicaDTO historiaDTO) {
		HistoriaClinicaModel historia = new HistoriaClinicaModel();
		historia.setId(historiaDTO.getId());
		historia.setAltura(historiaDTO.getAltura());
		historia.setPeso(historiaDTO.getPeso());
		historia.setPadecimientos(historiaDTO.getPadecimientos());
		historia.setDiagnosticoPrevio(historiaDTO.getDiagnosticoPrevio());
		
		return historia;
	}

	@Override
	public List<HistoriaClinicaDTO> obtenerHistoriaPorInfante(long infanteId) {
		List<HistoriaClinicaModel> historias = historiaRepositorio.findByInfanteId(infanteId);
		return historias.stream().map(historia -> mapearDTO(historia)).collect(Collectors.toList());
	}

	@Override
	public HistoriaClinicaDTO obtenerHistoriaPorId(Long infanteId, Long historiaId) {
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(()->new ResourceNotFoundException("infante", "id", infanteId));
		
		HistoriaClinicaModel historia = historiaRepositorio.findById(historiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Historia Clinica", "id", historiaId));
		
		if(!historia.getInfante().getId().equals(infante.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "La historia clinica no pertenece al infante");
		}
		
		return mapearDTO(historia);
	}

	@Override
	public HistoriaClinicaDTO actualizarHistoria(Long infanteId, Long historiaId, HistoriaClinicaDTO solicitudDeHistoria) {
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(()->new ResourceNotFoundException("infante", "id", infanteId));
		
		HistoriaClinicaModel historia = historiaRepositorio.findById(historiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Historia Clinica", "id", historiaId));
		
		if(!historia.getInfante().getId().equals(infante.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "La historia clinica no pertenece al infante");
		}
		
		historia.setAltura(solicitudDeHistoria.getAltura());
		historia.setDiagnosticoPrevio(solicitudDeHistoria.getDiagnosticoPrevio());
		historia.setPadecimientos(solicitudDeHistoria.getPadecimientos());
		historia.setPeso(solicitudDeHistoria.getPeso());
		
		HistoriaClinicaModel historiaActualizada = historiaRepositorio.save(historia);
		
		return mapearDTO(historiaActualizada);
	}

	@Override
	public void eliminarHistoria(Long infanteId, Long historiaId) {
		InfanteModel infante = infanteRepositorio.findById(infanteId)
				.orElseThrow(()->new ResourceNotFoundException("infante", "id", infanteId));
		
		HistoriaClinicaModel historia = historiaRepositorio.findById(historiaId)
				.orElseThrow(() -> new ResourceNotFoundException("Historia Clinica", "id", historiaId));
		
		if(!historia.getInfante().getId().equals(infante.getId())) {
			throw new ControlAppException(HttpStatus.BAD_REQUEST, "La historia clinica no pertenece al infante");
		}
		
		historiaRepositorio.delete(historia);
		
	}
	
}
