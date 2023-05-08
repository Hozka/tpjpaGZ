package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State implements Serializable {
	@Id
	@GeneratedValue
	private long stateId;
	
	//La valeur de l'état du ticket
	private String value;
	
	//Un etat est associ� � plusieurs tickets
	@OneToMany(mappedBy = "state")
	private List<Ticket> ticketsList;
	
	public State() {
		ticketsList = new ArrayList<Ticket>();
	}
	
	public State(String value, List<Ticket> ticketsList) {
		this.value = value;
		this.ticketsList = ticketsList;
	}



	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}
	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}
	
	

}
