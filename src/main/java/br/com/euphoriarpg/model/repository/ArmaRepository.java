package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.Arma;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Long>, JpaSpecificationExecutor<Arma> {

	@Query(value = "SELECT * FROM ARMA WHERE NOME=:nome", nativeQuery = true)
	Arma getArma(@Param("nome") String nome);

}
