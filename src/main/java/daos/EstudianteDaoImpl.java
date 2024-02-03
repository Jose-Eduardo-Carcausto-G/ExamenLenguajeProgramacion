package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;

public class EstudianteDaoImpl implements EstudianteDao{

	EntityManagerFactory factory;
	EntityManager em;

	public EstudianteDaoImpl() {

		factory = Persistence.createEntityManagerFactory("Semana01");
		em = factory.createEntityManager();
	}
	
	@Override
	public void create(Estudiante estudiante) {
		em.getTransaction().begin();
		em.persist(estudiante);
		em.getTransaction().commit();
	}

	@Override
	public Estudiante findById(int idEstudiante) {
		return em.find(Estudiante.class, idEstudiante);
		
	}

	@Override
	public List<Estudiante> findAll() {
		Query query = em.createNamedQuery("Estudiante.finAll");
		List<Estudiante> rolList = query.getResultList();
		return rolList;
	}

	@Override
	public void update(Estudiante estudiante) {
		try {
			em.getTransaction().begin();
			em.persist(estudiante);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}		
	}

	@Override
	public void delete(Estudiante estudiante) {
		em.getTransaction().begin();
		em.remove(estudiante);
		em.getTransaction().commit();		
	}

}
