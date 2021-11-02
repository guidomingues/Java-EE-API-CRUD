package br.com.cachaca.api_cachacaria.controller;

import java.util.List;

import javax.ejb.Stateless;
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

import br.com.cachaca.api_cachacaria.model.ComprarModel;
import br.com.cachaca.api_cachacaria.model.ProdutoModel;

@Stateless
@Path("/comprar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComprarController {

	
	@PersistenceContext
	EntityManager em;

	@GET
	public List<ComprarModel> buscarTodos() {
		return em.createQuery("Select n from Produto n", ComprarModel.class).getResultList();
	}

	@POST
	public ComprarModel criar(ComprarModel comprar) {    
		em.persist(comprar);
		return comprar;
	}

	@PUT
	public ComprarModel atualizar(ComprarModel comprar) {
		return em.merge(comprar);
	}

	@DELETE
	@Path("/{nome}")
	public void apagar(@PathParam("nome") String codigodeBarras) {
		ProdutoModel n = em.find(ProdutoModel.class, codigodeBarras);
		em.remove(n);
	}

}