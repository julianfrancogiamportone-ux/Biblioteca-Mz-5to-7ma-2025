package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Profesor;

public interface IProfesorService {
    public List<Profesor> findAllprofesor();
    public Profesor saveProfesor(Profesor profesor);
	public Optional<Profesor> findprofesorById(Long id);
	public void deleteProfesor(Long id);
	public void deleteProfesor(Profesor profesor);
	public void deleteAllprofesor();
}
