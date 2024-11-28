package br.com.euphoriarpg.model.service;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.entity.LogAuditoria;

@Service
public interface LogAuditoriaService {
	
	void insertLog(LogAuditoria dado);

}
