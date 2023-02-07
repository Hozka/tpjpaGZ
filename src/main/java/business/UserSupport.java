package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class UserSupport extends User {
	
	
	private String content;
	//relation commentaire et userSupport
	
	@OneToMany(mappedBy = "userSupport")
	private List<Comment> comments= new ArrayList<Comment>();
	
	// relation ticket et utilisateur Support
	@ManyToMany
	private List<Ticket> ticketList= new ArrayList<Ticket>();

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
	
	

}
