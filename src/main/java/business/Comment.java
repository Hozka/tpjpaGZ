package business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable {
	
	@Id
	@GeneratedValue
	private long commentId;
	
	private String content;
	//A un ticket sont associés plusieurs commentaires
	
	
	
	
	@ManyToOne
	private Ticket ticket;
	
	@ManyToOne
	private UserSupport userSupport;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public UserSupport getUserSupport() {
		return userSupport;
	}

	public void setUserSupport(UserSupport userSupport) {
		this.userSupport = userSupport;
	}
	
	
}
