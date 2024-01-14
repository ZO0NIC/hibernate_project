package hibernate.client;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.entity.Employee;
import hibernate.util.hibernateconfig;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee();
		//e.setName("ak");
		//e.setGender("Male");
		//e.setSalary(22200);
		//e.setId(2);
		
		
		//Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//SessionFactory sf = cfg.buildSessionFactory();
		
		SessionFactory ssr = hibernateconfig.getSessionFactory();
		Session session = ssr.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Query query1=session.createQuery("from Employee");
		List list=query1.list();  
		System.out.println(list);
		//session.save(e);
		
		//e=session.get(Employee.class, 2);
		//System.out.println(e);
		tx.commit();
		session.close();
	}

}
