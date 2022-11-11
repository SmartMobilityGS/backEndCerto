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

import br.com.gs.dao.BateriaDAO;
import br.com.gs.factory.ConnectionFactory;
import br.com.gs.to.BateriaTO;

@Path("/bateria")
public class BateriaResource {
	
	private BateriaDAO dao;
	
	public BateriaResource() {
		try {
			dao = new BateriaDAO(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BateriaTO> listar() throws SQLException {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register (BateriaTO bateria, @Context UriInfo uriInfo) {
		try {
			dao.register(bateria);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400, e.getMessage()).build();
		}
		
		uriInfo.getAbsolutePathBuilder().path(Integer.toString(bateria.getId()));
		
		return Response.created(uriInfo.getAbsolutePathBuilder().build()).build();
	}


}
