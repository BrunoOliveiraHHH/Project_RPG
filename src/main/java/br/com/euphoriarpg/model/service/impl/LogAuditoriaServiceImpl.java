package br.com.euphoriarpg.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.repository.LogAuditoriaRepository;
import br.com.euphoriarpg.model.service.LogAuditoriaService;

@Service
public class LogAuditoriaServiceImpl implements LogAuditoriaService {

	@Autowired
	private LogAuditoriaRepository repository;

	@Override
	public void insertLog(LogAuditoria dado) {

		try {
			repository.save(dado);
		} catch (Exception e) {
			throw new AplicacaoException(e.getMessage());
		}

	}

}
