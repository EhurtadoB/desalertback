package com.example.desalert_back.repositories;

import com.example.desalert_back.models.MedicoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MedicoRepository extends CrudRepository<MedicoModel, Long> {

}
