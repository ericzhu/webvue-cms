package ca.webvue.common.dao.jpa;

import org.springframework.stereotype.Repository;

import ca.webvue.common.entity.User;
import ca.webvue.common.dao.IUserDao;

@Repository
public class UserDaoJpa extends BaseDaoJpa<User, Long> implements IUserDao {
	
}
