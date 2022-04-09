package myproject.hibernate4.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import myproject.hibernate4.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/myproject/hibernate4/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			Employee emp = (Employee)session.get(Employee.class, 101);
			System.out.println(emp.getEno());
			System.out.println(emp.getEname());
			System.out.println(emp.getEsal());
			System.out.println(emp.getEaddr());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
	}
}
