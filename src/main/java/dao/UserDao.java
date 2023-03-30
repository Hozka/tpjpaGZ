package dao;

import business.User;

public class UserDao extends AbstractJpaDao<Long, User>{

	public UserDao(Class<User> clazz) {
		super(clazz);
		
	}

}
