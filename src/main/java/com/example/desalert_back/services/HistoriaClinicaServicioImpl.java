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
		historiaDTO.setA1(historia.getA1());
		historiaDTO.setAblactacion(historia.getAblactacion());
		historiaDTO.setAlergicos(historia.getAlergicos());
		historiaDTO.setAlteracionesLenguaje(historia.getAlteracionesLenguaje());
		historiaDTO.setAreacardiaca(historia.getAreacardiaca());
		historiaDTO.setBcg(historia.getBcg());
		historiaDTO.setBoca(historia.getBoca());
		historiaDTO.setCabeza(historia.getCabeza());
		historiaDTO.setCarne(historia.getCarne());
		historiaDTO.setCereales(historia.getCereales());
		historiaDTO.setCuello(historia.getCuello());
		historiaDTO.setDatosAnormales(historia.getDatosAnormales());
		historiaDTO.setDestete(historia.getDestete());
		historiaDTO.setDpto(historia.getDpto());
		historiaDTO.setDuracion(historia.getDuracion());
		historiaDTO.setEpatitisB(historia.getEpatitisB());
		historiaDTO.setEstudioPrevio(historia.getEstudioPrevio());
		historiaDTO.setFechaCreacion(historia.getFechaCreacion());
		historiaDTO.setFrecuenciaCardiaca(historia.getFrecuenciaCardiaca());
		historiaDTO.setFrecuenciaRespiratoria(historia.getFrecuenciaRespiratoria());
		historiaDTO.setFrutas(historia.getFrutas());
		historiaDTO.setHepatitis(historia.getHepatitis());
		historiaDTO.setHospitalizacion(historia.getHospitalizacion());
		historiaDTO.setImc(historia.getImc());
		historiaDTO.setInfecciones(historia.getInfecciones());
		historiaDTO.setInfluenza(historia.getInfluenza());
		historiaDTO.setLeche(historia.getLeche());
		historiaDTO.setLegumbres(historia.getLegumbres());
		historiaDTO.setNariz(historia.getNariz());
		historiaDTO.setNeumococo(historia.getNeumococo());
		historiaDTO.setOidos(historia.getOidos());
		historiaDTO.setOjos(historia.getOjos());
		historiaDTO.setPapiloma(historia.getPapiloma());
		historiaDTO.setParotiditis(historia.getParotiditis());
		historiaDTO.setPecho_materno(historia.getPecho_materno());
		historiaDTO.setPerimetroCefalico(historia.getPerimetroCefalico());
		historiaDTO.setPerimetroEmbarazo(historia.getPerimetroEmbarazo());
		historiaDTO.setPerimetroPierna(historia.getPerimetroPierna());
		historiaDTO.setPiel(historia.getPiel());
		historiaDTO.setPoliomelitis(historia.getPoliomelitis());
		historiaDTO.setPulmonar(historia.getPulmonar());
		historiaDTO.setQuirurgicos(historia.getQuirurgicos());
		historiaDTO.setRotavirus(historia.getRotavirus());
		historiaDTO.setRubeola(historia.getRubeola());
		historiaDTO.setSarampion(historia.getSarampion());
		historiaDTO.setSegmentoInterior(historia.getSegmentoInterior());
		historiaDTO.setSegmentoSuperior(historia.getSegmentoSuperior());
		historiaDTO.setSueros(historia.getSueros());
		historiaDTO.setTemperatura(historia.getTemperatura());
		historiaDTO.setTensionArterial(historia.getTensionArterial());
		historiaDTO.setTerapeutaPrevia(historia.getTerapeutaPrevia());
		historiaDTO.setTixoide(historia.getTixoide());
		historiaDTO.setTorax(historia.getTorax());
		historiaDTO.setTransfuciones(historia.getTransfuciones());
		historiaDTO.setTraumatismoicos(historia.getTraumatismoicos());
		historiaDTO.setVaricela(historia.getVaricela());
		
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
