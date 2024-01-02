package hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee vikas = new Employee();
//		vikas.setId(4);
		vikas.setName("kunal");
		vikas.setGender("Male");
		vikas.setSalary(12222);
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee e = session.get(Employee.class, 2);
		System.out.println(e);
		session.save(vikas);
		tx.commit();
		
	}

}