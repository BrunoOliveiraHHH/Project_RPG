package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.euphoriarpg.model.entity.Autenticacao;

public interface AuthenticationRepository extends JpaRepository<Autenticacao, Long>, JpaSpecificationExecutor<Autenticacao>{

}
