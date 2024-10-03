package hibernate_cache;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import HibernatePractice.Friend;
import HibernatePractice.Student;


public class Second_Level_Cache {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("HiberConfig.xml").buildSessionFactory();
		
		  Session s=	sf.openSession();
		  
		
		  Student  q = s.get(Student.class,18);
		  
		   
		   
		   System.out.println(q.toString());
		  
		  s.close();
		  
		  Session s1=	sf.openSession();
		  
		  Student  q1 = s1.get(Student.class,18);
	
		   System.out.println(q1);
		   
		   s1.close();
		   
		   // in second get student data get from session . data not fetched from DB.
		  
	}

}
