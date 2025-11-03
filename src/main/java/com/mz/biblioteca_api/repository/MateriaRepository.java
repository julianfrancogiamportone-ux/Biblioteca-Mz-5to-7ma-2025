package com.mz.biblioteca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mz.biblioteca_api.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    
}
