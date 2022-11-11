package br.com.gs.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.gs.dao.PlanoDAO;
import br.com.gs.factory.ConnectionFactory;
import br.com.gs.to.PlanoTO;

@Path("/plano")
public class PlanoResource {
	
	private PlanoDAO dao;
	
	public PlanoResource() {
		try {
			dao = new PlanoDAO(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlanoTO> listar() throws SQLException {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register (PlanoTO plano, @Context UriInfo uriInfo) {
		try {
			dao.register(plano);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400, e.getMessage()).build();
		}
		
		uriInfo.getAbsolutePathBuilder().path(Integer.toString(plano.getId()));
		
		return Response.created(uriInfo.getAbsolutePathBuilder().build()).build();
	}

}
