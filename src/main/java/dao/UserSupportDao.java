package dao;

import business.UserSupport;

public class UserSupportDao extends AbstractJpaDao<Long, UserSupport> {

	public UserSupportDao() {
		super(UserSupport.class);
		
	}

}
