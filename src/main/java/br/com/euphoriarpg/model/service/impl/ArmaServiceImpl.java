package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaDTO;
import br.com.euphoriarpg.model.entity.Arma;
import br.com.euphoriarpg.model.entity.Armadura;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.ArmaMapper;
import br.com.euphoriarpg.model.repository.ArmaRepository;
import br.com.euphoriarpg.model.service.ArmaService;
import br.com.euphoriarpg.model.service.LogAuditoriaService;

@Service
public class ArmaServiceImpl implements ArmaService {

	@Autowired
	private ArmaRepository repository;

	@Autowired
	private ArmaMapper mapper;

	@Autowired
	private LogAuditoriaService logAuditoria;

	@Override
	public List<Arma> getAll() {
		List<Arma> listaDados = repository.findAll();

		if (listaDados == null || listaDados.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.SEM_RETORNO_CONSULTA);
		}

		return listaDados;
	}

	@Override
	public Arma getById(Long id) {
		Optional<Arma> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		return dado.get();
	}

	@Override
	public Arma create(ArmaDTO dto) {
		Arma dado = repository.getArma(dto.getNome());

		if (dado != null) {
			throw new AplicacaoException(ExceptionValidacoes.OBJETO_JA_EXISTENTE);
		}

		dado = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), null, dado.toString(),
				AcaoEnum.INSERT, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dado);
	}

	@Override
	public Arma update(Long id, ArmaDTO dto) {
		Arma dadoAtual = repository.getArma(dto.getNome());

		if (dadoAtual == null) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		Arma dadoNovo = mapper.toEntity(dto);

		dadoNovo = this.validaCamposUpdate(dadoAtual, dadoNovo);

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), dadoAtual.toString(),
				dadoNovo.toString(), AcaoEnum.UPDATE, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dadoNovo);
	}

	private Arma validaCamposUpdate(Arma dadoAtual, Arma dadoNovo) {

		dadoAtual.setNome((dadoAtual.getNome().equals(dadoNovo.getNome()) ? dadoAtual.getNome() : dadoNovo.getNome()));
		dadoAtual.setCustoMoeda((dadoAtual.getCustoMoeda().equals(dadoNovo.getCustoMoeda()) ? dadoAtual.getCustoMoeda()
				: dadoNovo.getCustoMoeda()));
		dadoAtual.setDadoTipoDano(
				(dadoAtual.getDadoTipoDano().equals(dadoNovo.getDadoTipoDano()) ? dadoAtual.getDadoTipoDano()
						: dadoNovo.getDadoTipoDano()));
		dadoAtual.setObservacao((dadoAtual.getObservacao().equals(dadoNovo.getObservacao()) ? dadoAtual.getObservacao()
				: dadoNovo.getObservacao()));
		dadoAtual.setPeso((dadoAtual.getPeso().equals(dadoNovo.getPeso()) ? dadoAtual.getPeso() : dadoNovo.getPeso()));
		dadoAtual.setPropriedades(
				(dadoAtual.getPropriedades().equals(dadoNovo.getPropriedades()) ? dadoAtual.getPropriedades()
						: dadoNovo.getPropriedades()));

		return dadoAtual;
	}

	@Override
	public void delete(Long id) {
		Optional<Arma> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		repository.deleteById(id);
	}

	@Override
	public void delete(Long id, String usuario) {
		Optional<Arma> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), usuario));

		repository.deleteById(id);
	}
}
