package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business.Tag;
import business.User;
import dao.TagDao;
import dao.UserDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/tag")
@Produces({ "application/json", "application/xml" })
public class TagResource {

	private TagDao tagDAO;

	public TagResource() {
		tagDAO = new TagDao();
	}
	
	@GET
	@Path("/{tagId}")
	public Tag getUserById(@PathParam("tagId") Long tagId) {
		Tag tmp = tagDAO.findOne(tagId);
		return tmp;
	}
	
	@GET
	@Path("/all")
	public List<Tag> getAllTag() {
		return tagDAO.findAll();
	}
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addTag(
			@Parameter(description = "Tag object that needs to be added to the store", required = true) Tag t) {
		tagDAO.save(t);
		return Response.ok().entity("SUCCESS").build();
	}
}
