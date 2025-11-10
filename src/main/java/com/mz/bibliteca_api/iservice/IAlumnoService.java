package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Alumno;

public interface IAlumnoService {
    public List<Alumno> findAllAlumnos();
    public Alumno saveAlumnos(Alumno Alumnos);
	public Optional<Alumno> findAlumnosById(Long id);
	public void deleteAlumnos(Long id);
	public void deleteAlumnos (Alumno Alumnos);
	public void deleteAllAlumnos();
}
