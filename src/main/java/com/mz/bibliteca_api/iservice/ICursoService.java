package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Curso;

public interface ICursoService {
    public List<Curso> findAllCursos();
	public Curso saveCurso(Curso curso);
	public Optional<Curso> findCursoById(Long id);
	public void deleteCurso(Long id);
	public void deleteCurso(Curso curso);
	public void deleteAllCursos();
}