package HibernatePractice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id=0;
	private String name;
	@ManyToOne
	private Student std;
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Student getStd() {
		return std;
	}



	public void setStd(Student std) {
		this.std = std;
	}


//	We can not able to get std beacause of mapped by 

//	@Override
//	public String toString() {
//		return "Friend [id=" + id + ", name=" + name + ", std=" + std + "]";
//	}


	

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + "]";
	}



}
