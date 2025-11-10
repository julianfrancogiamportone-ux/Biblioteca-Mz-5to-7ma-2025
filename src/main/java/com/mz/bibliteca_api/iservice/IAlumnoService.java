package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Alumnos;

public interface IAlumnoService {
    public List<Alumnos> findAllAuthors();
    public Alumnos saveAlumnos(Alumnos Alumnos);
	public Optional<Alumnos> findAlumnosById(Long id);
	public void deleteAlumnos(Long id);
	public void deleteAlumnos (Alumnos Alumnos);
	public void deleteAllAlumnos();
}
