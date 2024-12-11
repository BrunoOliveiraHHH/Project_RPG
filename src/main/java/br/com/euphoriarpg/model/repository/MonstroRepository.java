package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.Monstro;

@Repository
public interface MonstroRepository extends JpaRepository<Monstro, Long>, JpaSpecificationExecutor<Monstro>{

	@Query(value = "SELECT * FROM ARMA WHERE NOME=:nome", nativeQuery = true)
	Monstro getMonstro(@Param("nome") String nome);

}
