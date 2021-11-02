package br.com.cachaca.api_cachacaria.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.cachaca.api_cachacaria.model.ClienteModel;

@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;
    
    public List<ClienteModel> getAll(){
    	return em.createQuery("Select c from UsuarioModel c ", ClienteModel.class).getResultList();
    }
}
