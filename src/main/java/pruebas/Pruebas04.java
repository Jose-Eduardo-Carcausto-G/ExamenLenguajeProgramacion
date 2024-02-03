package pruebas;

import java.util.List;

import daos.RolDao;
import daos.RolDaoImpl;
import model.Rol;

public class Pruebas04 {

	public static void main(String[] args) {

		RolDao dao=new RolDaoImpl();
		Rol rol = new Rol();
		rol.setRolName("tesorero");
		rol.setRolStatus(9);
		//dao.create(rol);
		
		
		List <Rol> rolList =dao.findAll();
		System.out.println("------- Se lista ----------");

		for (Rol r : rolList) {
			System.out.println(r.toString());			
		}
		System.out.println("-----------------");
		
		rol = dao.find(rolList.get(rolList.size()-1).getIdrol());
		System.out.println("-------- se va a modificar ---------");
		System.out.println(rol.toString());
		System.out.println("-----------------");
		
		int idr= rolList.get(rolList.size()-1).getIdrol();		
		rol.setIdrol(idr); 		
		
		rol.setRolStatus(6);
		rol.setRolName("gerente");
		dao.update(rol);		
		
		System.out.println("--------- queda asi --------");
		System.out.println(rol.toString());
		System.out.println("-----------------");

		System.out.println("---------se vuelve a listar--------");

		rolList =dao.findAll();
		for (Rol r : rolList) {
			System.out.println(r.toString());			
		}
		System.out.println("-----------------");
		
		rol = dao.find(rolList.get(rolList.size()-1).getIdrol());
		
		dao.delete(rol);
		rolList =dao.findAll();
		System.out.println("--------- se elimina --------");

		for (Rol r : rolList) {
			System.out.println(r.toString());
			
		}
		System.out.println("-----------------");
		
	}

}
