package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business.Subject;
import dao.SubjectDao;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/subject")
@Produces({ "application/json", "application/xml" })
public class SubjectResource {

	private SubjectDao subjectDAO;

	public SubjectResource() {
		subjectDAO = new SubjectDao();
	}
	
	@GET
	@Path("/{subjectId}")
	public Subject getUserById(@PathParam("subjectId") Long subjectId) {
		Subject tmp = subjectDAO.findOne(subjectId);
		return tmp;
	}
	
	@GET
	@Path("/all")
	public List<Subject> getAllSubject() {
		return subjectDAO.findAll();
	}
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addSubject(
			@Parameter(description = "Subject object that needs to be added to the store", required = true) Subject s) {
		subjectDAO.save(s);
		return Response.ok().entity("SUCCESS").build();
	}

}
