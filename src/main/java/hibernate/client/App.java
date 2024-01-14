package hibernate.client;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.entity.Employee;
import hibernate.entity.Address;
import hibernate.util.hibernateconfig;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee();
		//e.setName("ak");
		//e.setGender("Male");
		//e.setSalary(22200);
		//e.setId(2);
		
		System.out.println(">>1>>>>>>>>>>>>>>>");
		SessionFactory ssr = hibernateconfig.getSessionFactory();
		Session session1 = ssr.openSession();
		System.out.println(">>1>>>>>>>>>>>>>>>");
		save(session1);
		fetchAllEmployees(session1);
		System.out.println("..............Close Session .............");
		session1.close();
	}
	
	@SuppressWarnings("deprecation")
	private static void fetchAllEmployees(Session session) {
		System.out.println("...............Employees Fetching...........");
		List<Employee> resultList = session.createQuery("From Employee", Employee.class).getResultList();
		for (Employee employee : resultList) {
			System.out.println(employee);
		}
//		System.out.println(resultList.get(1).getAddress());
		System.out.println("...............Employees end...........");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Address> resultList = session.createQuery("From Address", Address.class).getResultList();
		for (Address add : resultList) {
			System.out.print(add+"     "+add.getEmployee());
		}
//		System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}
	
	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e = new Employee();
		e.setName("ak");
		e.setGender("Male");
		e.setSalary(69420);
		Address address = new Address("GZB", "UP");
//		address.employee = e;
		e.setAddress(address);
		address.setEmployee(e);
		session.persist(address);
		session.persist(e);
//		Employee e1 = new Employee();
//		e1.setFirstName("Mihir");
//		e1.setLastName("binoli");
//		Address address1 = new Address("lucknow", "Kanpur");
//		address1.employee = e1;
//		e1.setAddress(address1);;

//		session.persist(address1);
//		session.persist(e1);
		transaction.commit();
	}

}
