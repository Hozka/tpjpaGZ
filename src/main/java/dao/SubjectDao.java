package dao;

import business.State;
import business.Subject;

public class SubjectDao extends AbstractJpaDao<Long, Subject>{

	public SubjectDao() {
		super(Subject.class);
		
	}

}
