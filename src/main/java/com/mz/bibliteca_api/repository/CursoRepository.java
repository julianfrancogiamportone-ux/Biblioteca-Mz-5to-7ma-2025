package com.mz.bibliteca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.bibliteca_api.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
