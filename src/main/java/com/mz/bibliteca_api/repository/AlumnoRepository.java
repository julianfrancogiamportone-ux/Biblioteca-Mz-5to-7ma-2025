package com.mz.bibliteca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.bibliteca_api.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {}