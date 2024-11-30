package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaduraDTO;
import br.com.euphoriarpg.model.entity.Armadura;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.ArmaduraMapper;
import br.com.euphoriarpg.model.repository.ArmaduraRepository;
import br.com.euphoriarpg.model.service.ArmaduraService;
import br.com.euphoriarpg.model.service.LogAuditoriaService;

@Service
public class ArmaduraServiceImpl implements ArmaduraService {
	@Autowired
	private ArmaduraRepository repository;

	@Autowired
	private ArmaduraMapper mapper;

	@Autowired
	private LogAuditoriaService logAuditoria;

	@Override
	public List<Armadura> getAll() {
		List<Armadura> listaDados = repository.findAll();

		if (listaDados == null || listaDados.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.SEM_RETORNO_CONSULTA);
		}

		return listaDados;
	}

	@Override
	public Armadura getById(Long id) {
		Optional<Armadura> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		return dado.get();
	}

	@Override
	public Armadura create(ArmaduraDTO dto) {
		Armadura dado = repository.getArmadura(dto.getNome());

		if (dado != null) {
			throw new AplicacaoException(ExceptionValidacoes.OBJETO_JA_EXISTENTE);
		}

		dado = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), null, dado.toString(),
				AcaoEnum.INSERT, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dado);
	}

	@Override
	public Armadura update(Long id, ArmaduraDTO dto) {
		Armadura dadoAtual = repository.getArmadura(dto.getNome());

		if (dadoAtual == null) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		Armadura dadoNovo = mapper.toEntity(dto);

		dadoNovo = this.validaCamposUpdate(dadoAtual, dadoNovo);

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), dadoAtual.toString(),
				dadoNovo.toString(), AcaoEnum.UPDATE, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dadoNovo);
	}

	private Armadura validaCamposUpdate(Armadura dadoAtual, Armadura dadoNovo) {

		dadoAtual.setNome((dadoAtual.getNome().equals(dadoNovo.getNome()) ? dadoAtual.getNome() : dadoNovo.getNome()));
		dadoAtual.setCustoMoeda((dadoAtual.getCustoMoeda().equals(dadoNovo.getCustoMoeda()) ? dadoAtual.getCustoMoeda()
				: dadoNovo.getCustoMoeda()));
		dadoAtual.setClasseDeArmadura((dadoAtual.getClasseDeArmadura().equals(dadoNovo.getClasseDeArmadura())
				? dadoAtual.getClasseDeArmadura()
				: dadoNovo.getClasseDeArmadura()));
		dadoAtual.setObservacao((dadoAtual.getObservacao().equals(dadoNovo.getObservacao()) ? dadoAtual.getObservacao()
				: dadoNovo.getObservacao()));
		dadoAtual.setPeso((dadoAtual.getPeso().equals(dadoNovo.getPeso()) ? dadoAtual.getPeso() : dadoNovo.getPeso()));
		dadoAtual.setForca(
				(dadoAtual.getForca().equals(dadoNovo.getForca()) ? dadoAtual.getForca() : dadoNovo.getForca()));
		dadoAtual.setFurtividade(
				(dadoAtual.getFurtividade().equals(dadoNovo.getFurtividade()) ? dadoAtual.getFurtividade()
						: dadoNovo.getFurtividade()));

		return dadoAtual;
	}

	@Override
	public void delete(Long id) {
		Optional<Armadura> dado = repository.findById(id);

		if (!dado.isPresent()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), null));

		repository.deleteById(id);
	}

	@Override
	public void delete(Long id, String usuario) {
		Optional<Armadura> dado = repository.findById(id);

		if (!dado.isPresent()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Armadura.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), usuario));

		repository.deleteById(id);
	}
}
