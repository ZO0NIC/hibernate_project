package hibernate.client;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.entity.Employee;
import hibernate.util.hibernateconfig;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee();
		//e.setId(2);
		e.setName("zzzhaok");
		e.setGender("Male");
		e.setSalary(22200);
		
		//Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//SessionFactory sf = cfg.buildSessionFactory();
		
		SessionFactory ssr = hibernateconfig.getSessionFactory();
		Session session = ssr.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(e);
		//session.update(e);
		
		//e=session.get(Employee.class, 2);
		//System.out.println(e);
		tx.commit();
		
	}

}
