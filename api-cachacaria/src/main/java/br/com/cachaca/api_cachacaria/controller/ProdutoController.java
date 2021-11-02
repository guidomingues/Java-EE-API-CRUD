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

import br.com.cachaca.api_cachacaria.model.ProdutoModel;

@Stateless
@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

	@PersistenceContext
	EntityManager em;

	@GET
	public List<ProdutoModel> buscarTodos() {
		return em.createQuery("Select p from Produto p", ProdutoModel.class).getResultList();
	}

	@POST
	public ProdutoModel criar(ProdutoModel produto) {    
		em.persist(produto);
		return produto;
	}

	@PUT
	public ProdutoModel atualizar(ProdutoModel produto) {
		return em.merge(produto);
	}

	@DELETE
	@Path("/{codigoDeBarras}")
	public void apagar(@PathParam("codigoDeBarras") String codigodeBarras) {
		ProdutoModel p = em.find(ProdutoModel.class, codigodeBarras);
		em.remove(p);
	}

}
