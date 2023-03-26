package dao;

import business.Subject;

public class SubjectDao extends AbstractJpaDao<Long, Subject>{

	public SubjectDao(Class<Subject> clazz) {
		super(clazz);
		
	}

}
