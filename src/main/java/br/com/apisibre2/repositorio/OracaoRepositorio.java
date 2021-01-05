package br.com.apisibre2.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisibre2.model.OracaoModel;

@Repository
public interface OracaoRepositorio extends JpaRepository<OracaoModel, Long>{

	List<OracaoModel> findByNomeContainingIgnoreCase(String nome);
}
