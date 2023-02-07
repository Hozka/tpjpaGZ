package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {
	@Id
	@GeneratedValue
	private long stateId;
	
	private String content;
	//Un etat est associé à plusieurs tickets
	@OneToMany(mappedBy = "state")
	private List<Ticket> ticketsList = new ArrayList<Ticket>();
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
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
