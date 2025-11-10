package com.mz.bibliteca_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mz.bibliteca_api.entity.Materia;
import com.mz.bibliteca_api.iservice.IMateriaService;
import com.mz.bibliteca_api.repository.MateriaRepository;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public void deleteById(Integer id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public Materia findById(Integer id) {
        return materiaRepository.findById(id).orElse(null);
    }
}