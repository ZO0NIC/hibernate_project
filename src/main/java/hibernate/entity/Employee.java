package hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//(name = "ducat_emp")
public class Employee {
	@Column(name="userName")
	private String name;
	@Column
	private String gender;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int salary;
	@OneToOne//(cascade = CascadeType.ALL)
//	@JoinColumn(name = "addFK")
	private Address address;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", id=" + id + ", salary=" + salary + "]";
	}
}
