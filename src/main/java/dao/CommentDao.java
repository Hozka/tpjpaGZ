package dao;

import business.Comment;

public class CommentDao  extends AbstractJpaDao<Long, Comment>{

	public CommentDao() {
		super(Comment.class);
	}

}
