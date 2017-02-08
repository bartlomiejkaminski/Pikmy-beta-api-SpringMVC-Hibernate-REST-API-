package com.pikmy.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RestController;

import com.pikmy.hibernate.util.HibernateUtil;

@RestController
public class PikmyController {
	
	//SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	//Session session = sessionFactory.getCurrentSession();
	//try {
	//session.beginTransaction();
	//session.save(p);		
	//session.getTransaction().commit();
	//}
	//catch (RuntimeException e) {
	//	session.getTransaction().rollback();
	//    throw e;
	//}
	
	
}
