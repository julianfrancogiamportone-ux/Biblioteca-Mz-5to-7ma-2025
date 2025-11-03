ackage com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;

import com.mz.bibliteca_api.entity.Alumnos;

public interface IAlumnoService {
    public List<Alumnos> findAllAuthors();
    public Alumnos saveAlumnos(alumnos Alumnos);
	public Optional<Alumnos> findAlumnosById(Long id);
	public void deleteAlumnos(Long id);
	public void deleteAlumnos (alumnos Alumnos);
	public void deleteAllAlumnos();
}
