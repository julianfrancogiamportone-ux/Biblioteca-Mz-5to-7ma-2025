package com.mz.bibliteca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mz.bibliteca_api.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    
}