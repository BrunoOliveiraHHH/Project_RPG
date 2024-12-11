package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.euphoriarpg.model.dto.MonstroDTO;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.entity.Monstro;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.MonstroMapper;
import br.com.euphoriarpg.model.repository.MonstroRepository;
import br.com.euphoriarpg.model.service.LogAuditoriaService;
import br.com.euphoriarpg.model.service.MonstroService;

public class MonstroServiceImpl implements MonstroService {
	
	@Autowired
	private MonstroRepository repository;

	@Autowired
	private MonstroMapper mapper;

	@Autowired
	private LogAuditoriaService logAuditoria;

	@Override
	public List<Monstro> getAll() {
		List<Monstro> listaDados = repository.findAll();

		if (listaDados == null || listaDados.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.SEM_RETORNO_CONSULTA);
		}

		return listaDados;
	}

	@Override
	public Monstro getById(Long id) {
		Optional<Monstro> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		return dado.get();
	}

	@Override
	public Monstro create(MonstroDTO dto) {
		Monstro dado = repository.getMonstro(dto.getNome());

		if (dado != null) {
			throw new AplicacaoException(ExceptionValidacoes.OBJETO_JA_EXISTENTE);
		}

		dado = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Monstro.class.toGenericString(), null, dado.toString(),
				AcaoEnum.INSERT, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dado);
	}

	@Override
	public Monstro update(Long id, MonstroDTO dto) {
		Monstro dadoAtual = repository.getMonstro(dto.getNome());

		if (dadoAtual == null) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		Monstro dadoNovo = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Monstro.class.toGenericString(), dadoAtual.toString(),
				dadoNovo.toString(), AcaoEnum.UPDATE, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dadoNovo);
	}

	@Override
	public void delete(Long id) {
		Optional<Monstro> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}
		
		logAuditoria.insertLog(new LogAuditoria(Monstro.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), null));

		repository.deleteById(id);
	}

	@Override
	public void delete(Long id, String usuario) {
		Optional<Monstro> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Monstro.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), usuario));

		repository.deleteById(id);
	}

}
