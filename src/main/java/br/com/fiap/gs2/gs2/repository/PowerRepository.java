package br.com.fiap.gs2.gs2.repository
;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gs2.gs2.model.Power;

@Repository
public interface PowerRepository 
	extends JpaRepository<Power, Long> {

	<T> T findByNome(String nome, Class<T> type);
	<T> List<T> findAllByNome(String nome, Class<T> type);
	<T> List<T> findAllByNomeContains(String nome, Class<T> type);
}

