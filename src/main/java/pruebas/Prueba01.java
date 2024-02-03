package pruebas;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Rol;

public class Prueba01 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Semana01");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createNamedQuery("Rol.finAll");
		List<Rol> rolList = query.getResultList();
		
		Query query2=em.createQuery("Select r from Rol r");
		List<Rol> rolList2 = query2.getResultList();

		for(Rol r: rolList) {
			System.out.println(r.toString());
			System.out.println("-------------------");	
		}
		for(Rol r2: rolList2) {
			System.out.println(r2.toString());
			System.out.println("-------------------");	
		}
	}

}
