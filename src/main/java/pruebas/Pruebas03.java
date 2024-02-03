package pruebas;

import java.util.List;

import daos.*;
import model.*;
public class Pruebas03 {

	public static void main(String[] args) {

		RolDao dao =new RolDaoImpl();
		List<Rol> rolList =dao.findAll();
		
		for(Rol r: rolList) {
			System.out.println(r.toString());
		}
	}

}
