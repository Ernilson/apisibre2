package br.com.apisibre2.service;

import java.util.List;

import br.com.apisibre2.model.ContatoModel;

public interface ContatoService {

	List<ContatoModel> listAll();

	List<ContatoModel> findByNomeContainingIgnoreCase(String nome);
	
	ContatoModel saveOrUpdate(ContatoModel cm);

	boolean alterar(ContatoModel dto);

	ContatoModel getId(Long id);	

	void delete(Long id);
}
