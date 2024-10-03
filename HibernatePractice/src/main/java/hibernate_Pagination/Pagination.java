package hibernate_Pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import HibernatePractice.Friend;

public class Pagination {
	
	public static void main(String[] args) {
		
		
	 SessionFactory sf= new Configuration ().configure("HiberConfig.xml").buildSessionFactory();
	      
	   Session session  = sf.openSession();
	   
	    Transaction t  =session.beginTransaction();
	    
	    Query q =  session.createQuery("from Friend");
	  
	    
	  q.setFirstResult(0);
	  q.setMaxResults(1);
	  List<Friend> s = q.list();
	
	  
	  for(Friend fri :s) {
		  System.out.println(fri.getName());
	  }
	  
	    
	    t.commit();
	    sf.close();
	      
	      
	}

}
