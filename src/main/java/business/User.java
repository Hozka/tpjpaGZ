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
	
	/**
	 * Nom de l'utilisateur
	 */
	private String lastName;
	
	/**
	 * Prénom de l'utilisateur
	 */
	private String firstName;
	
	/**
	 * Type de l'utilisateur
	 * 0: Normal, 1: Support
	 */
	private String type;
	
	//Declarer une liste de ticket parce qu'un user a plusieurs tickets
	@OneToMany(mappedBy = "user")
	private List<Ticket> ticketsList;
	
	public User() {
		ticketsList = new ArrayList<Ticket>();
		type = "0";
	}
	
	@XmlElement(name = "id")
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@XmlElement(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "ticketsList")
	public List<Ticket> getTicketsList() {
		return ticketsList;
	}
	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}
	public void addTicket(Ticket t) {
		ticketsList.add(t);
	}
	
	

}
