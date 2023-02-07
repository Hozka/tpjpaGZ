package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class User {
	
	@Id
	@GeneratedValue
	private long userId;
	
	private String content;
	//Declarer une liste de ticket parce qu'un user a plusieurs tickets
	@OneToMany(mappedBy = "user")
	private List<Ticket> ticketsList = new ArrayList<Ticket>();
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Ticket> getTicketsList() {
		return ticketsList;
	}
	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}
	
	

}
