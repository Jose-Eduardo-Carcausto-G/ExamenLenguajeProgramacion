package pruebas;

import java.util.List;

import daos.SubjectDao;
import daos.SubjectDaoImpl;
import model.Subject;

public class test {

	public static void main(String[] args) {

		SubjectDao dao=new SubjectDaoImpl();
		Subject subject = new Subject();
		subject.setSubject("Matematicas");
		subject.setCredits("4");
		
		
		List <Subject> subjectList =dao.findAll();
		System.out.println("------- Se lista ----------");

		for (Subject r : subjectList) {
			System.out.println(r.toString());			
		}
		System.out.println("-----------------");
		
		subject = dao.find(subjectList.get(subjectList.size()-1).getIdsubject());
		System.out.println("-------- se va a modificar ---------");
		System.out.println(subject.toString());
		System.out.println("-----------------");
		
		int ids= subjectList.get(subjectList.size()-1).getIdsubject();		
		subject.setIdsubject(ids); 		
		
		subject.setCredits("6");
		subject.setSubject("Historia");
		dao.update(subject);		
		
		System.out.println("--------- queda asi --------");
		System.out.println(subject.toString());
		System.out.println("-----------------");

		System.out.println("---------se vuelve a listar--------");

		subjectList =dao.findAll();
		for (Subject r : subjectList) {
			System.out.println(r.toString());			
		}
		System.out.println("-----------------");
		
		subject = dao.find(subjectList.get(subjectList.size()-1).getIdsubject());
		
		dao.delete(subject);
		subjectList =dao.findAll();
		System.out.println("--------- se elimina --------");

		for (Subject r : subjectList) {
			System.out.println(r.toString());
			
		}
		System.out.println("-----------------");
		
	}

}
