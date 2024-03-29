package co.uk.escape.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEB")
public class EmployeeB {

	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "AGE", nullable = false)
	private long age;
	
	public EmployeeB() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

}
