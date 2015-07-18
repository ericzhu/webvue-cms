package ca.webvue.common.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import ca.webvue.common.dao.IUserDao;
import ca.webvue.common.entity.User;
import ca.webvue.common.service.IUserService;

@Service
public class UserService extends BaseService<User, Long> implements IUserService {
	
	@Inject
	@Named("userDaoJpa")
	public void setBaseDao(IUserDao userDao) {
		super.setBaseDao(userDao);
	}
}
