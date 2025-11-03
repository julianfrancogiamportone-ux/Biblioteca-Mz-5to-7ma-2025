package com.mz.biblioteca_api.IService;

import java.util.List;
import com.mz.biblioteca_api.entity.Materia;

public interface IMateriaService {
    List<Materia> findAll();
    Materia save(Materia materia);
    void deleteById(Integer id);
    Materia findById(Integer id);
}