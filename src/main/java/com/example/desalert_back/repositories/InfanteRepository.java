package com.example.desalert_back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.desalert_back.models.InfanteModel;

@Repository
public interface InfanteRepository extends CrudRepository<InfanteModel, Long>{

}
