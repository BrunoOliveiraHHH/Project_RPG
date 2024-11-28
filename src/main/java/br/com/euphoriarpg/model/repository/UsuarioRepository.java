package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.repository.specifications.UsuarioRepositoryCustom;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>, UsuarioRepositoryCustom {

	@Query(value = "SELECT * FROM USUARIO WHERE UPPER(LOGIN)=UPPER(:login)", nativeQuery = true)
	Usuario getByLogin(@Param("login") String login);

}
