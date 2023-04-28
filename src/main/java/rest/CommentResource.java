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
import dao.CommentDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/comment")
@Produces({ "application/json", "application/xml" })
public class CommentResource {

	private CommentDao commentDAO;

	public CommentResource() {
		commentDAO = new CommentDao();
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getUserById(@PathParam("commentId") Long commentId) {
		Comment tmp = commentDAO.findOne(commentId);
		return tmp;
	}
	
	@GET
	@Path("/all")
	public List<Comment> getAllComment() {
		return commentDAO.findAll();
	}
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addComment(
			@Parameter(description = "Comment object that needs to be added to the store", required = true) Comment c) {
		commentDAO.save(c);
		return Response.ok().entity("SUCCESS").build();
	}

}
