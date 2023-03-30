package dao;

import business.Ticket;

public class TicketDao  extends AbstractJpaDao<Long, Ticket>{

	public TicketDao(Class<Ticket> clazz) {
		super(clazz);
		
	}

}
