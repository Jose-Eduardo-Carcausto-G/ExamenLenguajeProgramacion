package daos;

import java.util.List;

import model.Estudiante;

public interface EstudianteDao {

	public void create(Estudiante estudiante);

	public Estudiante findById(int idEstudiante);

	public List<Estudiante> findAll();

	public void update(Estudiante estudiante);

	public void delete(Estudiante estudiante);
}
