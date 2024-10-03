package Hibernate_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sf = new Configuration().configure("DBconfig.cfg.xml").buildSessionFactory();
    	
    	
    	
    	Session os = sf.openSession();
    	Transaction t = os.beginTransaction();
    	
    	Address adr = new Address();
    	
    	adr.setStreet("Hinjewadi");
    	adr.setCity("Pune");
    	adr.setOpen(true);
    	adr.setAddDate(new Date());
    	adr.setX(123456789);
    	
    	try {
			FileInputStream fis =new FileInputStream("src/main/java/Capture - Copy.PNG");
			byte[] data =new byte[fis.available()];
			fis.read(data);
			adr.setImage(data);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	os.save(adr);
    	
    	t.commit();
    	os.close();
    }
}
