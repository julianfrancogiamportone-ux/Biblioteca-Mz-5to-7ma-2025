package com.mz.bibliteca_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bibliteca_api.entity.Curso;
import com.mz.bibliteca_api.iservice.ICursoService;
import com.mz.bibliteca_api.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
	public List<Curso> findAllCursos() {
		return cursoRepository.findAll();
	};
	
	@Override
	public Curso saveCurso(Curso curso) {
		return cursoRepository.save(curso);
	};
	
	@Override
	public Optional<Curso> findCursoById(Long id) {
		return cursoRepository.findById(id);
	};
	
	@Override
	public void deleteCurso(Long id) {
		cursoRepository.deleteById(id);
	}
	
	@Override
	public void deleteCurso(Curso curso) {
		cursoRepository.delete(curso);
	};
	
	@Override
	public void deleteAllCursos() {
		cursoRepository.deleteAll();
	}
}
