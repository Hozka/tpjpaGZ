package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business.Comment;
import business.State;
import business.Ticket;
import business.User;
import business.UserSupport;
import dao.CommentDao;
import dao.TicketDao;
import dao.UserDao;
import dao.UserSupportDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/usersupport")
@Produces({ "application/json", "application/xml" })
public class UserSupportResource {

	private UserSupportDao userDAO;

	public UserSupportResource() {
		userDAO = new UserSupportDao();
	}

	@GET
	@Path("/{usersupportId}")
	public User getUserById(@PathParam("usersupportId") Long usersupportId) {
		User tmp = userDAO.findOne(usersupportId);
		return tmp;
	}

	@POST
	@Consumes("application/json")
	public Response addUserSupport(
			@Parameter(description = "User object that needs to be added to the store", required = true) UserSupport user) {
		userDAO.save(user);
		return Response.ok().entity("SUCCESS").build();
	}

	@POST
	@Path("/{usersupportId}/{ticketId}/addComment")
	@Consumes("application/json")
	public UserSupport addCommentToTicket(@PathParam("usersupportId") Long usersupportId,
			@PathParam("ticketId") Long ticketId,
			@Parameter(description = "add comment to ticket", required = true) Comment comment) {

		UserSupport tmpUser = userDAO.findOne(usersupportId);
		if (tmpUser != null) {
			TicketDao ticketDAO = new TicketDao();
			Ticket t = ticketDAO.findOne(ticketId);
			if (t != null && !comment.getTexte().equals("")) {// Si commentaire avec des caractères
				// On sauvegarde le commentaire
				Comment c = new Comment();
				c.setTexte(comment.getTexte());
				c.setUserSupport(tmpUser);
				CommentDao tampDAO = new CommentDao();
				tampDAO.save(c);

				// On ajoute le commentaire au ticket puis on le sauvegarde
				t.addComment(c);
				ticketDAO.update(t);
			}
		}
		return tmpUser;
	}

}
