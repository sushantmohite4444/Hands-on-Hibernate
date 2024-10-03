package many_To_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.ManyToAny;




@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	
	@ManyToMany(targetEntity = Projects.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "emp_prod_table", 
				joinColumns = { @JoinColumn(name="emp_id") },
				inverseJoinColumns = { @JoinColumn(name = "pro_id") })
	private List< Projects> project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Projects> getProject() {
		return project;
	}

	public void setProject(List<Projects> project) {
		this.project = project;
	}

	//bidirectional
	//one to one 
	//one to many
	//many to many

}
