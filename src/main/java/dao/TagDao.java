package dao;

import business.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag> {

	public TagDao(Class<Tag> clazz) {
		super(clazz);
		
	}

}
