package br.com.apisibre2.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisibre2.model.ContatoModel;


@Repository
public interface ContatoRepositorio  extends JpaRepository<ContatoModel, Long>{

	List<ContatoModel> findByNomeContainingIgnoreCase(String nome);

}
