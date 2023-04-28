package dao;

import business.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag> {

	public TagDao() {
		super(Tag.class);
		
	}

}
