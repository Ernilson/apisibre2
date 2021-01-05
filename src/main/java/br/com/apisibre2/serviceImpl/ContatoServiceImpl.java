package br.com.apisibre2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisibre2.model.ContatoModel;
import br.com.apisibre2.repositorio.ContatoRepositorio;
import br.com.apisibre2.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepositorio cr;

	@Override
	public List<ContatoModel> listAll() {
		List<ContatoModel> cm = new ArrayList<>();
		cr.findAll().forEach(cm::add); // fun with Java 8
		return cm;
	}

	@Override
	public List<ContatoModel> findByNomeContainingIgnoreCase(String nome) {
		return cr.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public ContatoModel saveOrUpdate(ContatoModel cm) {
		cr.save(cm);
		return cm;
	}

	@Override
	public boolean alterar(ContatoModel dto) {
		try {
			 cr.save(dto);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}
	
	@Override
	public ContatoModel getId(Long id) {
		return cr.findById(id).get();
	}

	@Override
	public void delete(Long id) {
	cr.deleteById(id);
	}

}
