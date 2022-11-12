package br.com.gs.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.gs.bo.UsuarioBO;
import br.com.gs.dao.UsuarioDAO;
import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.factory.ConnectionFactory;
import br.com.gs.to.UsuarioTO;
import oracle.jdbc.proxy.annotation.Post;

@Path("/usuario")
public class UsuarioResource {
	
	private UsuarioBO bo;
	private UsuarioDAO dao;

	public UsuarioResource() {
		try {
			bo = new UsuarioBO(ConnectionFactory.getConnection());
			dao = new UsuarioDAO(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> getAll() throws SQLException{
		return bo.getAll();
	}
	
	 @GET
	 @Path("/id/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public UsuarioTO getById(@PathParam("id") int id) throws SQLException, IdNotFoundException{
	     return dao.getById(id);
	 }
	    
	 @GET
	 @Path("/tipo/{tipo}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<UsuarioTO> getByTipo(@PathParam("tipo") String tipo) throws SQLException{
	     return dao.getByTipo(tipo);
	 }
	
	@Post
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(UsuarioTO usuario, @Context UriInfo uriInfo) throws SQLException {
		
		bo.register(usuario);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		builder.path(Integer.toString(usuario.getId()));
		
		return Response.created(builder.build()).build();
	}
}
