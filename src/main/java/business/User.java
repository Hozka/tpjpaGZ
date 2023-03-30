package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
@Entity
@Inheritance
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private long userId;
	
	private String content;
	//Declarer une liste de ticket parce qu'un user a plusieurs tickets
	@OneToMany(mappedBy = "user")
	private List<Ticket> ticketsList = new ArrayList<Ticket>();
	

	@XmlElement(name = "id")
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}


	@XmlElement(name = "content")
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
