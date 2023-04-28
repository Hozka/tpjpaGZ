package business;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject implements Serializable {
	
	@Id
	@GeneratedValue
	private int subjectId;
	
	/*
	 * Le texte du sujet*/
	private String text;
	
	@OneToMany(mappedBy = "subject")
	private List<Ticket> ticketList;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
	
	
}
