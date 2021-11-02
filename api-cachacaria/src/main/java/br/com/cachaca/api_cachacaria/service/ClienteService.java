package br.com.cachaca.api_cachacaria.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.cachaca.api_cachacaria.DAO.ClienteDAO;
import br.com.cachaca.api_cachacaria.DTO.ClienteDTO;
import br.com.cachaca.api_cachacaria.model.ClienteModel;

public class ClienteService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ClienteDAO clienteDAO; 
	
	private ClienteDTO convertToDTO(ClienteModel cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setEndereco(cliente.getEndereco());
		clienteDTO.setNome(cliente.getNome());
		return clienteDTO;
	}

	public List<ClienteModel> listarTodosUsuarios() {
		return clienteDAO.getAll();
	}
	
}
