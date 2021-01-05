package br.com.apisibre2.service;

import java.util.List;

import br.com.apisibre2.model.OracaoModel;

public interface OracaoService {
	
	List<OracaoModel> listAll();

	List<OracaoModel> findByNomeContainingIgnoreCase(String nome);
	
	OracaoModel saveOrUpdate(OracaoModel cm);

	boolean alterar(OracaoModel dto);

	OracaoModel getId(Long id);	

	void delete(Long id);

}
