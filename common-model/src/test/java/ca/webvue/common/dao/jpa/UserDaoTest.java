package ca.webvue.common.dao.jpa;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ca.webvue.common.dao.IUserDao;
import ca.webvue.common.entity.User;
import ca.webvue.common.query.Filter;
import ca.webvue.test.util.AbstractDbUnitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/appContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserDaoTest extends AbstractDbUnitTestCase {

	@Inject
	IUserDao userDao;
	
	@Test
	public void testLoad() throws Exception {
		IDataSet ds = createDateSet("t_user");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		User u = userDao.find(1L);
		System.out.println(userDao.find(1L).getUsername());
		assertNotNull(u);
	}
	
	@Test
	public void testRemove() throws Exception {
		IDataSet ds = createDateSet("t_user");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		userDao.remove(userDao.find(1L));
		assertNull(userDao.find(1L));
	}
	
	@Test
	public void testFindList() throws Exception {
		IDataSet ds = createDateSet("t_user");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		
		Filter filter = new Filter();
		filter.setOperator(Filter.Operator.eq);
		filter.setProperty("username");
		filter.setValue("admin2");
		
		List<User> users = userDao.findList(Integer.valueOf(0), Integer.MAX_VALUE, Arrays.asList(filter), null);
		System.out.println(users.get(0).getId());
		assertEquals(1, users.size());
	}

	@Before
	public void setup() throws Exception {
		this.backupAllTable();
	}

	@After
	public void teardown() throws Exception {
		this.resumeTable();
	}
}
