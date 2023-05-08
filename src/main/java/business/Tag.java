package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag implements Serializable{
	@Id
	@GeneratedValue
	private long tagId;
	
	//La valeur textuelle du tag
	private String value;
	
	//relation ticket tag
	@ManyToMany
	private List<Ticket> ticketList;
	
	public Tag() {
		ticketList= new ArrayList<Ticket>();
	}
	
	public Tag(String value, List<Ticket> ticketList) {
		this.value = value;
		this.ticketList = ticketList;
	}



	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
	
	

}
