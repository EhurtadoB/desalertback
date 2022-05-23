package com.example.desalert_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desalert_back.models.AuxiliarModel;

@Repository
public interface AuxiliarRepository  extends JpaRepository<AuxiliarModel, Long>{

}
