package ca.webvue.common.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.webvue.common.entity.User;

public class UserDaoTest {
	
	@Test
	public void testSave() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
		
		EntityManagerFactory emf = appContext.getBean("entityManagerFactory", EntityManagerFactory.class);
		
		EntityManager em = emf.createEntityManager();
		
		User u = new User();
		em.getTransaction().begin();
		u.setName("Test");
		em.persist(u);
		em.getTransaction().commit();
		emf.close();
		appContext.close();
		
	}
}
