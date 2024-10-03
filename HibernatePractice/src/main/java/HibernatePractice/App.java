package HibernatePractice;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import oracle.net.aso.f;

public class App {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("HiberConfig.xml").buildSessionFactory();

		Student std = new Student();
		std.setLname("Mohite");
		std.setName("sushant");

		ArrayList<Friend> fl = new ArrayList<Friend>();

		Friend friend = new Friend();
		
		friend.setName("sushant");
		friend.setStd(std);
		
		Friend friend1 = new Friend();
		
		friend1.setName("satish");
		friend1.setStd(std);
		
		Friend friend2 = new Friend();
		
		friend2.setName("sanket");
		friend2.setStd(std);

		fl.add(friend);
		fl.add(friend1);
		fl.add(friend2);

		std.setFd(fl);

		Session os = sf.openSession();

		Transaction t = os.beginTransaction();
		


		os.save(std);

//		Student st = (Student)os.get(Student.class,17);
//		
//		System.out.print(st.getName());
//	
//		 for (Friend friend3 : st.getFd()) {
//			System.out.println(friend3);
//		}
//	
//
//		System.out.println(st);

		t.commit();
		os.close();

	}
}
