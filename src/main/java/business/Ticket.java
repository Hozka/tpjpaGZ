package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ticket implements Serializable {
	@Id
	@GeneratedValue
	private long ticketId;

	/**
	 * La description du problème soulevé par le ticket
	 */
	private String description;

	/**
	 * L'utilisateur initiateur du ticket
	 */
	@ManyToOne
	private User user;

	// L'état en temps réel du ticket
	@ManyToOne
	private State state;

	// Le sujet associé au ticket
	@ManyToOne
	private Subject subject;

	/**
	 * Les commentaires du ticket
	 */
	@OneToMany(mappedBy = "ticket")
	private List<Comment> commentList;

	// Les tags du ticket
	@ManyToMany(mappedBy = "ticketList")
	private List<Tag> tagList =  new ArrayList<>();;

	// Les users support en charge du ticket
	@ManyToMany(mappedBy = "ticketList")
	private List<UserSupport> userSupportList;

	public Ticket() {
		commentList = new ArrayList<>();
		tagList = new ArrayList<>();
		userSupportList = new ArrayList<>();
	}

	
	
	public Ticket(String description, User user, State state, Subject subject, List<Comment> commentList,
			List<Tag> tagList, List<UserSupport> userSupportList) {
		this.description = description;
		this.user = user;
		this.state = state;
		this.subject = subject;
		this.commentList = commentList;
		this.tagList = tagList;
		this.userSupportList = userSupportList;
	}



	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public void addComment(Comment c) {
		commentList.add(c);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public void addTag(Tag tag) {
		tagList.add(tag);
	}

	public List<UserSupport> getUserSupportList() {
		return userSupportList;
	}

	public void setUserSupportList(List<UserSupport> userSupportList) {
		this.userSupportList = userSupportList;
	}

}
