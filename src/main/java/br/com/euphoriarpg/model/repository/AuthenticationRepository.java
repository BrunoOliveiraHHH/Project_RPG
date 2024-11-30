package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.euphoriarpg.model.entity.Autenticacao;

public interface AuthenticationRepository extends JpaRepository<Autenticacao, Long>, JpaSpecificationExecutor<Autenticacao>{

	@Query(value = "SELECT * FROM AUTENTICACAO WHERE LOGIN=:login AND ROWNUM = 1 ORDER BY DT_LOGIN DESC", nativeQuery = true)
	Autenticacao getByIdAndLastRecord(@Param("login")String login);

}
