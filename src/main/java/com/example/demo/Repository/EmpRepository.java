package com.example.demo.Repository;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Employee;


@Repository
public class EmpRepository {

	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory() {
		
			Configuration configuration = new Configuration().configure("hbm.configure.xml");
			factory = configuration.buildSessionFactory();
			}	
	
	public List<Employee> getAll(){
		
		Session session = factory.openSession();
		List<Employee> list = (List<Employee>) session.createCriteria(Employee.class).list();
		session.close();
		return list;
	}
	
	public void deleteEmployeebyId(int Empid) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee_toremove = session.find(Employee.class, Empid);
		session.delete(employee_toremove);   // object must have the id
		transaction.commit();
		session.close();
	}
	
	public Employee findEmployeebyId(int Empid) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.find(Employee.class, Empid);
		transaction.commit();
		session.close();
		return employee;
	}
	
	public void saveEmployee(Employee employee)
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
	}
	

}
