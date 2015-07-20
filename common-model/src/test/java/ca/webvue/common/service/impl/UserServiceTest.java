package ca.webvue.common.service.impl;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.webvue.common.service.IUserService;

public class UserServiceTest {

	@Test
	public void testCount() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
		IUserService userService = appContext.getBean("userService", IUserService.class);
		System.out.println(userService.count());
		appContext.close();
	}
}
