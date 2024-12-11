package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.entity.Npc;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.NpcMapper;
import br.com.euphoriarpg.model.repository.NpcRepository;
import br.com.euphoriarpg.model.service.LogAuditoriaService;
import br.com.euphoriarpg.model.service.NpcService;


@Service
public class NpcServiceImpl implements NpcService {

	@Autowired
	private NpcRepository repository;
	
	@Autowired
	private NpcMapper mapper;

	@Autowired
	private LogAuditoriaService logAuditoria;

	@Override
	public List<Npc> getAll() {
		List<Npc> listaDados = repository.findAll();

		if (listaDados == null || listaDados.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.SEM_RETORNO_CONSULTA);
		}

		return listaDados;
	}

	@Override
	public Npc getById(Long id) {
		Optional<Npc> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		return dado.get();
	}

	@Override
	public Npc create(NpcDTO dto) {
		Npc dado = repository.getNpc(dto.getNome(), dto.getIdade(), dto.getRaca(), dto.getClasse());

		if (dado != null) {
			throw new AplicacaoException(ExceptionValidacoes.OBJETO_JA_EXISTENTE);
		}

		dado = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Npc.class.toGenericString(), null, dado.toString(),
				AcaoEnum.INSERT, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dado);
	}

	@Override
	public Npc update(Long id, NpcDTO dto) {
		Npc dadoAtual = repository.findByIdNpc(id);

		if (dadoAtual == null) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		Npc dadoNovo = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Npc.class.toGenericString(), dadoAtual.toString(),
				dadoNovo.toString(), AcaoEnum.UPDATE, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dadoNovo);
	}

	@Override
	public List<Npc> getNpcByNome(String nome) {
		List<Npc> dado = repository.findByNome(nome);

		if (dado == null) {
			throw new AplicacaoException("Npc não encontrado!");
		}

		return dado;
	}

	@Override
	public void delete(Long id) {
		Optional<Npc> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Npc.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), null));

		repository.deleteById(id);
	}

	@Override
	public void delete(Long id, String usuario) {
		Optional<Npc> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Npc.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), usuario));

		repository.deleteById(id);
	}

}
