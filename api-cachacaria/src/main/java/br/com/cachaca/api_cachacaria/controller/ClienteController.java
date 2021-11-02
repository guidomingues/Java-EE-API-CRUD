package br.com.cachaca.api_cachacaria.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.cachaca.api_cachacaria.model.ClienteModel;
import br.com.cachaca.api_cachacaria.service.ClienteService;


@Stateless
@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {
	
	@PersistenceContext
	EntityManager em;

	//@Inject
	//private ClienteService service;
	
	@GET
	public List<ClienteModel> buscarTodos() {
		return em.createQuery("Select c from Cliente c", ClienteModel.class).getResultList();
	}

	//@GET
	//public ResponseBuilder getAll() {
		//return Response.ok(service.listarTodosUsuarios()); 
	// }
	
	@POST
	public ClienteModel criar(ClienteModel cliente) {
		em.persist(cliente);
		return cliente;
	}

	@PUT
	public ClienteModel atualizar(ClienteModel cliente) {
		return em.merge(cliente);
	}

	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") String id) {
		ClienteModel c = em.find(ClienteModel.class, id);
		em.remove(c);
	}

}
