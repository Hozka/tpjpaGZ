package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business.Ticket;
import business.User;
import dao.TicketDao;
import dao.UserDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({ "application/json", "application/xml" })
public class UserResource {

	private UserDao userDAO;

	public UserResource() {
		userDAO = new UserDao();
	}

	@GET
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") Long userId) {
		User tmp = userDAO.findOne(userId);
		return tmp;
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addUser(
			@Parameter(description = "User object that needs to be added to the store", required = true) User user) {
		userDAO.save(user);
		return Response.ok().entity("SUCCESS").build();
	}

	@GET
	@Path("/all")
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	@POST
	@Path("/{userId}/addTicket")
	@Consumes("application/json")
	public User addTicketToUser(@PathParam("userId") Long userId,
			@Parameter(description = "add ticket to user", required = true) Ticket ticket) {
		User user = userDAO.findOne(userId);
		if (user != null) {
			TicketDao tDAO = new TicketDao();
			Ticket tmp = tDAO.findOne(ticket.getTicketId());
			if (tmp != null) {
				user.addTicket(tmp);
				userDAO.save(user);
			}
		}
		return user;
	}

	@DELETE
	@Path("/{userId}")
	@Consumes("application/json")
	public Response deleteUser(@PathParam("userId") Long userId) {
		User user = userDAO.findOne(userId);
		if (user != null) {
			userDAO.delete(user);
		}
		return Response.ok().entity("SUCCESS").build();
	}

	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateUser(
			@Parameter(description = "User object that needs to be update", required = true) User user) {
		userDAO.update(user);
		return Response.ok().entity("SUCCESS").build();
	}

}
