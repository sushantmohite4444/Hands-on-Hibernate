package hibernate_SQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import HibernatePractice.Friend;

public class Sql {

	public static void main(String[] args) {
		
		
		
		SessionFactory sf = new Configuration().configure("HiberConfig.xml").buildSessionFactory();
	
	  Session s=	sf.openSession();
		
		Query nq =  s.createNativeQuery("select * from Friend");
		
		List<Object[]> friend =  nq.list();
		
		for(Object[] fri : friend) {
			System.out.println(Arrays.toString(fri));
		}
		
		s.close();
		
		
		
	}

}
