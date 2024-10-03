package hibernate_HQL;



import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import many_To_many.Employee;
import many_To_many.Projects;

public class HQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		SessionFactory sf = new Configuration().configure("HiberConfig.xml").buildSessionFactory();

		Session s=	sf.openSession();
		Transaction tran=  s.beginTransaction();
		
//		String  query = "from Employee as emp where name='qwe'";
//		String  query = "delete from Employee as emp where emp.name=:j";
//		String  query = "update from Employee as emp where emp.name=:j";
		
String  query = "select emp.name ,emp.id from Employee as emp INNER JOIN emp.project as pro where pro.pro_name= 'Spring' ";
		Query q =  s.createQuery(query);
		
//		q.setParameter("j", "qwe");
		
		//q.uniqueResult(); single obj
	 
        	List<Object[]> e=	q.list();
        	
        	
	
for (Object[] emp : e) {
	System.out.println(Arrays.toString(emp));
		
		
	}
		
		
		
		tran.commit();
		sf.close();
		

	}

}
