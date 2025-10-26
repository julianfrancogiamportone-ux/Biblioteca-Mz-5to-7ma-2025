package com.mz.bibliteca_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mz.bibliteca_api.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    
}
