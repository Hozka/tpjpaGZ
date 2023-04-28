package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business.State;
import dao.StateDao;
import dao.TagDao;
import io.swagger.v3.oas.annotations.Parameter;


@Path("/state")
@Produces({ "application/json", "application/xml" })
public class StateResource {

	private StateDao stateDAO;

	public StateResource() {
		stateDAO = new StateDao();
	}

	@GET
	@Path("/{tagId}")
	public State getUserById(@PathParam("stateId") Long stateId) {
		State tmp = stateDAO.findOne(stateId);
		return tmp;
	}

	@GET
	@Path("/all")
	public List<State> getAllState() {
		return stateDAO.findAll();
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addState(
			@Parameter(description = "State object that needs to be added to the store", required = true) State s) {
		stateDAO.save(s);
		return Response.ok().entity("SUCCESS").build();

	}
}
