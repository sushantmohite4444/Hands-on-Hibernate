package criteria_API;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import many_To_many.Employee;

public class CriteriaApi {

	public static void main(String[] args) {
		
	SessionFactory sf =new Configuration().configure("HiberConfig.xml").buildSessionFactory();
		
	Session s=	sf.openSession();
	
	 Criteria c=  s.createCriteria(Employee.class);
	 
	 c.add(Restrictions.eq("name", "qwe"));
	 // use hiber doc for more knowledge
	 
	 
	   List<Employee> emp = c.list();
	   
	   for(Employee empl :emp) {
		   System.out.println(empl.getName());
	   }
	   
	   s.close();
		
	}
	

}
