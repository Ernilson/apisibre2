package br.com.apisibre2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisibre2.model.OracaoModel;
import br.com.apisibre2.repositorio.OracaoRepositorio;
import br.com.apisibre2.service.OracaoService;

@Service
public class OracaoServiceImpl implements OracaoService{

	@Autowired
	private OracaoRepositorio cr;
	
	@Override
	public List<OracaoModel> listAll() {
		List<OracaoModel> cm = new ArrayList<>();
		cr.findAll().forEach(cm::add); // fun with Java 8
		return cm;
	}

	@Override
	public List<OracaoModel> findByNomeContainingIgnoreCase(String nome) {
		return cr.findByNomeContainingIgnoreCase(nome);
	}


	@Override
	public OracaoModel saveOrUpdate(OracaoModel cm) {
		cr.save(cm);
		return cm;
	}

	@Override
	public boolean alterar(OracaoModel dto) {
		try {
			 cr.save(dto);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public OracaoModel getId(Long id) {
		return cr.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		cr.deleteById(id);
	}

	
}
