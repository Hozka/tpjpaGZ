package dao;

import business.State;

public class StateDao extends AbstractJpaDao<Long, State> {

	public StateDao() {
		super(State.class);
	}
	
	

}
