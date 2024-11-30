package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.LogAuditoria;

@Repository
public interface LogAuditoriaRepository extends JpaRepository<LogAuditoria, Long>, JpaSpecificationExecutor<LogAuditoria>{

}
