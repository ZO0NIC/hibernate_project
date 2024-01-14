package hibernate.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//(name = "ducat_emp")
public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name="userName")
	private String name;
	@Column
	private String gender;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int salary;
//	@JoinColumn(name = "addFK")
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	List<Address> address;

	public Employee(String name, String gender, int salary, List<Address> address) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", id=" + id + ", salary=" + salary + "]";
	}
}
