package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.entity.Item;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.ItemMapper;
import br.com.euphoriarpg.model.repository.ItemRepository;
import br.com.euphoriarpg.model.service.ItemService;
import br.com.euphoriarpg.model.service.LogAuditoriaService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@Autowired
	private ItemMapper mapper;
	
	@Autowired
	private LogAuditoriaService logAuditoria;

	@Override
	public List<Item> getAll() {
		List<Item> listaDados = repository.findAll();

		if (listaDados == null || listaDados.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.SEM_RETORNO_CONSULTA);
		}

		return listaDados;
	}

	@Override
	public Item getById(Long id) {
		Optional<Item> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		return dado.get();
	}

	@Override
	public Item create(ItemDTO dto) {
		Item dado = repository.getItem(dto.getNome());

		if (dado != null) {
			throw new AplicacaoException(ExceptionValidacoes.OBJETO_JA_EXISTENTE);
		}

		dado = mapper.toEntity(dto);

		logAuditoria.insertLog(new LogAuditoria(Item.class.toGenericString(), null, dado.toString(),
				AcaoEnum.INSERT, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dado);
	}

	@Override
	public Item update(Long id, ItemDTO dto) {
		Item dadoAtual = repository.getItem(dto.getNome());

		if (dadoAtual == null) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		Item dadoNovo = mapper.toEntity(dto);

		dadoNovo = this.validaCamposUpdate(dadoAtual, dadoNovo);

		logAuditoria.insertLog(new LogAuditoria(Item.class.toGenericString(), dadoAtual.toString(),
				dadoNovo.toString(), AcaoEnum.UPDATE, LocalDateTime.now(), dto.getUsuario()));

		return repository.save(dadoNovo);
	}

	private Item validaCamposUpdate(Item dadoAtual, Item dadoNovo) {

		dadoAtual.setNome((dadoAtual.getNome().equals(dadoNovo.getNome()) ? dadoAtual.getNome() : dadoNovo.getNome()));
		dadoAtual.setCustoMoeda((dadoAtual.getCustoMoeda().equals(dadoNovo.getCustoMoeda()) ? dadoAtual.getCustoMoeda()
				: dadoNovo.getCustoMoeda()));
		dadoAtual.setDescricao(
				(dadoAtual.getDescricao().equals(dadoNovo.getDescricao()) ? dadoAtual.getDescricao()
						: dadoNovo.getDescricao()));
		dadoAtual.setObservacao((dadoAtual.getObservacao().equals(dadoNovo.getObservacao()) ? dadoAtual.getObservacao()
				: dadoNovo.getObservacao()));
		dadoAtual.setPeso((dadoAtual.getPeso().equals(dadoNovo.getPeso()) ? dadoAtual.getPeso() : dadoNovo.getPeso()));

		return dadoAtual;
	}

	@Override
	public void delete(Long id) {
		Optional<Item> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Item.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), null));

		repository.deleteById(id);
	}

	@Override
	public void delete(Long id, String usuario) {
		Optional<Item> dado = repository.findById(id);

		if (dado.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		logAuditoria.insertLog(new LogAuditoria(Item.class.toGenericString(), dado.toString(), null,
				AcaoEnum.DELETE, LocalDateTime.now(), usuario));

		repository.deleteById(id);
		
	}

}
