package br.com.cachaca.api_cachacaria.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.cachaca.api_cachacaria.DTO.ProdutoDTO;
import br.com.cachaca.api_cachacaria.model.ProdutoModel;

public class ProdutoService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private ProdutoDTO convertToDTO(ProdutoModel produto) {
		
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setCodigoDeBarra(produto.getCodigoDeBarras());
		produtoDTO.setNome(produto.getNome());
		return produtoDTO;
	}
	
	private List<ProdutoDTO> convertToListDTO(List<ProdutoModel> listaDeProduto) {
		List<ProdutoDTO> listaDeProdutoDTO = new ArrayList<ProdutoDTO>();
		for(ProdutoModel produto:listaDeProduto) {
			ProdutoDTO produtoDTO = convertToDTO(produto);
			listaDeProdutoDTO.add(produtoDTO);
		}
		return listaDeProdutoDTO;
	}

}
