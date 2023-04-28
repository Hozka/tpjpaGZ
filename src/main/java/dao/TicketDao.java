package dao;

import business.Ticket;

public class TicketDao  extends AbstractJpaDao<Long, Ticket>{

	public TicketDao() {
		super(Ticket.class);
		
	}

}
