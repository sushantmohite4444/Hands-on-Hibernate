package many_To_many;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyTOMany {

	public static void main(String[] args) {
		
SessionFactory sf = new Configuration().configure("HiberConfig.xml").buildSessionFactory();

	Session s=	sf.openSession();
	Transaction tran=  s.beginTransaction();
	

	Projects pro1 =new Projects();
	pro1.setPro_name("Spring");
	
	
	
	Projects pro2 =new Projects();
	pro2.setPro_name("Hibernate");
	
	
	Projects pro3 =new Projects();
	pro3.setPro_name("Spring boot");
	

	
	Employee emp1 =new Employee();
	emp1.setName("qwe");
	ArrayList<Projects> projects= new ArrayList<Projects>();
	
	projects.add(pro1);
	projects.add(pro2);
	emp1.setProject(projects);
	
	
	Employee emp2 =new Employee();
	emp2.setName("asd");
	
   ArrayList<Projects> projects1= new ArrayList<Projects>();
	projects1.add(pro1);
	projects1.add(pro2);
	projects1.add(pro3);
	
	emp2.setProject(projects1);
	
	
	
	
	
	s.save(emp1);
	s.save(emp2);
	s.save(pro1);
	s.save(pro2);
	s.save(pro3);
	
	
	tran.commit();
	s.close();


	}

}
