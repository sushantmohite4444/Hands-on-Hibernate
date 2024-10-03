package HibernatePractice;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Generated;

import antlr.collections.List;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id=0 ;
	private String name;
	private String lname;
	
	@OneToMany(mappedBy ="std",cascade = CascadeType.ALL)
//	@OneToMany
	private java.util.List<Friend> fd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public java.util.List<Friend> getFd() {
		return fd;
	}

	public void setFd(java.util.List<Friend> fd) {
		this.fd = fd;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lname=" + lname  + "]";
	}

	
	
	
	
}
