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
	
	private String content;
	
	//Plusieurs tickets appartiennent à un utilisateur
	//La relation entre la classe Ticket et la classe User est une relation OneToMany
	@ManyToOne
	private User user;
	
	//Un ticket  est associé à plusieurs sujets donc OneToMany
	@OneToMany(mappedBy="ticket")
	private List<Subject> subjectList =new ArrayList<Subject>();
	
	//Un ticket est associé à plusieurs commentaires
	@OneToMany(mappedBy = "ticket")
	private List<Comment> commentList= new ArrayList<Comment>();

	//Un ticket à un seul etat
	@ManyToOne
	private State state;
	
	//Relation ticket et Tag
	@ManyToMany(mappedBy="ticketList")
	private List<Tag> tagList= new ArrayList<Tag>();
	
	// relation ticket et utilisateur Support
		
	@ManyToMany(mappedBy="ticketList")
	private List<UserSupport> userSupportList= new ArrayList<UserSupport>();

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
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

	public List<UserSupport> getUserSupportList() {
		return userSupportList;
	}

	public void setUserSupportList(List<UserSupport> userSupportList) {
		this.userSupportList = userSupportList;
	}
	
	
}
