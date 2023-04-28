package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business.Comment;
import business.State;
import business.Tag;
import business.Ticket;
import business.User;
import dao.CommentDao;
import dao.StateDao;
import dao.TagDao;
import dao.TicketDao;
import dao.UserDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/ticket")
@Produces({ "application/json", "application/xml" })
public class TicketResource {

	private TicketDao ticketDAO;

	public TicketResource() {
		ticketDAO = new TicketDao();
	}

	@GET
	@Path("/{ticketId}")
	public Ticket getTicketById(@PathParam("ticketId") Long ticketId) {
		Ticket tmp = ticketDAO.findOne(ticketId);
		return tmp;
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addTicket(
			@Parameter(description = "Ticket object that needs to be added to the store", required = true) Ticket t) {
		if (t != null) {
			ticketDAO.save(t);
			return Response.ok().entity("SUCCESS").build();
		} else {

			return Response.ok().entity("FAIL").build();
		}
	}

	@GET
	@Path("/all")
	public List<Ticket> getAllTicket() {
		return ticketDAO.findAll();
	}

	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateTicket(
			@Parameter(description = "Ticket object that needs to be update", required = true) Ticket t) {
		if (t != null) {
			ticketDAO.update(t);
			return Response.ok().entity("SUCCESS").build();
		} else {

			return Response.ok().entity("FAIL").build();
		}
	}

	@POST
	@Path("/{ticketId}/addTag")
	@Consumes("application/json")
	public Ticket addTagToTicket(@PathParam("ticketId") Long ticketId,
			@Parameter(description = "add tag to ticket", required = true) Tag tag) {
		Ticket t = ticketDAO.findOne(ticketId);
		if (t != null) {
			TagDao tampDAO = new TagDao();
			Tag tmp = tampDAO.findOne(tag.getTagId());
			if (tmp != null) {
				t.addTag(tmp);
				ticketDAO.save(t);
			}
			
		}
		return t;
	}

	@POST
	@Path("/{ticketId}/updateState")
	@Consumes("application/json")
	public Ticket updateTicketState(@PathParam("ticketId") Long ticketId,
			@Parameter(description = "update ticket state", required = true) State state) {
		Ticket t = ticketDAO.findOne(ticketId);
		if (t != null) {
			StateDao tampDAO = new StateDao();
			State tmp = tampDAO.findOne(state.getStateId());
			if (tmp != null) {
				t.setState(tmp);
				ticketDAO.save(t);
			}
		}
		return t;
	}

	

}
