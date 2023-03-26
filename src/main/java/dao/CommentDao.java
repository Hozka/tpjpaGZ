package dao;

import business.Comment;

public class CommentDao  extends AbstractJpaDao<Long, Comment>{

	public CommentDao(Class<Comment> clazz) {
		super(clazz);
	}

}
