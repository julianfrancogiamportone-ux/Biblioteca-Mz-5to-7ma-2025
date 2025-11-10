package com.mz.bibliteca_api.iservice;

import java.util.List;
import com.mz.bibliteca_api.entity.Materia;

public interface IMateriaService {
    List<Materia> findAll();
    Materia save(Materia materia);
    void deleteById(Integer id);
    Materia findById(Integer id);
}