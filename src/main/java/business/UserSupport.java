package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class UserSupport extends User {

	/*
	 * Liste des commentaires de l'user support
	 */
	@OneToMany(mappedBy = "userSupport")
	private List<Comment> comments;

	/*
	 * Liste des tickets pris en charge par le support
	 */
	@ManyToMany
	private List<Ticket> ticketList;

	
	public UserSupport() {
		comments = new ArrayList<Comment>();
		ticketList = new ArrayList<Ticket>();
		setType("1");
	}

	@XmlElement(name = "comments")
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@XmlElement(name = "ticketList")
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

}
