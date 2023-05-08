package business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Comment")
@Entity
public class Comment implements Serializable {
	
	@Id
	@GeneratedValue
	private long commentId;
	
	//Le texte du commentaire
	private String texte;
	
	
	//A un ticket sont associ�s plusieurs commentaires
	@ManyToOne
	private Ticket ticket;
	
	@ManyToOne
	private UserSupport userSupport;

	
	
	public Comment(String texte, Ticket ticket, UserSupport userSupport) {
		this.texte = texte;
		this.ticket = ticket;
		this.userSupport = userSupport;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
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
