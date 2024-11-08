package br.com.euphoriarpg.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.entity.Item;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.mapper.ItemMapper;
import br.com.euphoriarpg.model.repository.ItemRepository;
import br.com.euphoriarpg.model.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@Autowired
	private ItemMapper mapper;

	@Override
	public List<Item> getAll() {
		List<Item> listaDados = repository.findAll();

		if (listaDados == null) {
			return new ArrayList<>();
		}

		return listaDados;
	}

	@Override
	public Item getById(Long id) {
		Optional<Item> dado = repository.findById(id);

		if (!dado.isPresent()) {
			return new Item();
		}

		return dado.get();
	}

	@Override
	public Item create(ItemDTO dto) {
		Item dado = repository.getItem(dto.getNome());

		if (dado != null) {
			return new Item();
		}

		dado = mapper.convertDtoToEntity(dto);

		return repository.save(dado);
	}

	@Override
	public Item update(Long id, ItemDTO dto) {
		Item dadoAtual = repository.getItem(dto.getNome());

		if (dadoAtual == null) {
			return new Item();
		}

		Item dadoNovo = mapper.convertDtoToEntity(dto);

		dadoNovo = this.validaCamposUpdate(dadoAtual, dadoNovo);

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

		if (!dado.isPresent()) {
			throw new AplicacaoException("Arma não existe.");
		}
		repository.deleteById(id);
	}

}
