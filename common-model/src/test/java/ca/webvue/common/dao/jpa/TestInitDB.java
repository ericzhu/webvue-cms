package ca.webvue.common.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.webvue.common.entity.User;

public class TestInitDB {
	
	@Test
	public void testInitDB() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
		EntityManagerFactory emf = appContext.getBean("entityManagerFactory", EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User u = new User();
		u.setUsername("test username");
		em.persist(u);
		
		em.getTransaction().commit();
		
		appContext.close();
	}
	
}
