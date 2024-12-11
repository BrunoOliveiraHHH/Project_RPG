package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.Armadura;

@Repository
public interface ArmaduraRepository  extends JpaRepository<Armadura, Long>, JpaSpecificationExecutor<Armadura> {

	@Query(value = "SELECT * FROM ARMADURA WHERE NOME=:nome", nativeQuery = true)
	Armadura getArmadura(@Param("nome") String nome);

}
