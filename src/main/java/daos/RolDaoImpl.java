package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Rol;

public class RolDaoImpl implements RolDao {
	EntityManagerFactory factory;
	EntityManager em;

	public RolDaoImpl() {

		factory = Persistence.createEntityManagerFactory("Semana01");
		em = factory.createEntityManager();
	}

	@Override
	public void create(Rol rol) {
		em.getTransaction().begin();
		em.persist(rol);
		em.getTransaction().commit();
	}

	@Override
	public void update(Rol rol) {
		try {
			em.getTransaction().begin();
			em.persist(rol);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Rol rol) {
		em.getTransaction().begin();
		em.remove(rol);
		em.getTransaction().commit();
	}

	@Override
	public Rol find(Integer id) {
			return em.find(Rol.class, id);
	}

	@Override
	public List<Rol> findAll() {
		Query query = em.createNamedQuery("Rol.finAll");
		List<Rol> rolList = query.getResultList();
		return rolList;
	}

}
