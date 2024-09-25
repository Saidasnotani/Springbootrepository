package com.example.demo.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee;

@Repository
public class LoginRepository {

	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory() {
		
			Configuration configuration = new Configuration().configure("hbm.configure.xml");
			factory = configuration.buildSessionFactory();
			}	
	
	public boolean checkLoginUserbyname(String username) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery(" from Login where login_user="+username);
		List list = q.list();
		if(!list.isEmpty())
		{
			System.out.println("Login successful");
			transaction.commit();
			session.close();
		return true;
		}
		transaction.commit();
		session.close();
		return false;
	}
}
