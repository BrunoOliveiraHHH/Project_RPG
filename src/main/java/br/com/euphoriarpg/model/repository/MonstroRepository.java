package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.Monstro;

@Repository
public interface MonstroRepository extends JpaRepository<Monstro, Long>, JpaSpecificationExecutor<Monstro>{

}
