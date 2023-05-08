package business;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject implements Serializable {
	
	@Id
	@GeneratedValue
	private long subjectId;
	
	/*
	 * Le texte du sujet*/
	private String text;
	
	@OneToMany(mappedBy = "subject")
	private List<Ticket> ticketList;

	
	
	public Subject() {
		ticketList = new ArrayList<>();
	}

	public Subject(String text, List<Ticket> ticketList) {
		this.text = text;
		this.ticketList = ticketList;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
	
	
}
