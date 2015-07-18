package ca.webvue.common.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.webvue.common.entity.User;
import ca.webvue.common.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/appContext.xml")
public class UserDaoTest {

	@Inject
	IUserService userService;
	
	@Test
	public void testSave() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"appContext.xml");

		EntityManagerFactory emf = appContext.getBean("entityManagerFactory",
				EntityManagerFactory.class);

		EntityManager em = emf.createEntityManager();

		User u = new User();
		em.getTransaction().begin();
		u.setName("Test");
		em.persist(u);
		em.getTransaction().commit();
		emf.close();
		appContext.close();

	}
	
	@Test
	public void testCount() {
		System.out.println(userService.count());
	}
}
