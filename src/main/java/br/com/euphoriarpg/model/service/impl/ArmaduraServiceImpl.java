package br.com.euphoriarpg.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaduraDTO;
import br.com.euphoriarpg.model.entity.Armadura;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.mapper.ArmaduraMapper;
import br.com.euphoriarpg.model.repository.ArmaduraRepository;
import br.com.euphoriarpg.model.service.ArmaduraService;

@Service
public class ArmaduraServiceImpl implements ArmaduraService {
	@Autowired
	private ArmaduraRepository repository;

	@Autowired
	private ArmaduraMapper mapper;

	@Override
	public List<Armadura> getAll() {
		List<Armadura> listaDados = repository.findAll();

		if (listaDados == null) {
			return new ArrayList<>();
		}

		return listaDados;
	}

	@Override
	public Armadura getArmadura(Long id) {
		Optional<Armadura> dado = repository.findById(id);

		if (!dado.isPresent()) {
			return new Armadura();
		}

		return dado.get();
	}

	@Override
	public Armadura create(ArmaduraDTO dto) {
		Armadura dado = repository.getArmadura(dto.getNome());

		if (dado != null) {
			return new Armadura();
		}

		dado = mapper.convertDtoToEntity(dto);

		return repository.save(dado);
	}

	@Override
	public Armadura update(ArmaduraDTO dto) {
		Armadura dadoAtual = repository.getArmadura(dto.getNome());

		if (dadoAtual == null) {
			return new Armadura();
		}

		Armadura dadoNovo = mapper.convertDtoToEntity(dto);

		dadoNovo = this.validaCamposUpdate(dadoAtual, dadoNovo);

		return repository.save(dadoNovo);
	}

	private Armadura validaCamposUpdate(Armadura dadoAtual, Armadura dadoNovo) {

		dadoAtual.setNome((dadoAtual.getNome().equals(dadoNovo.getNome()) ? dadoAtual.getNome() : dadoNovo.getNome()));
		dadoAtual.setCustoMoeda((dadoAtual.getCustoMoeda().equals(dadoNovo.getCustoMoeda()) ? dadoAtual.getCustoMoeda()
				: dadoNovo.getCustoMoeda()));
		dadoAtual.setClasseDeArmadura(
				(dadoAtual.getClasseDeArmadura().equals(dadoNovo.getClasseDeArmadura()) ? dadoAtual.getClasseDeArmadura()
						: dadoNovo.getClasseDeArmadura()));
		dadoAtual.setObservacao((dadoAtual.getObservacao().equals(dadoNovo.getObservacao()) ? dadoAtual.getObservacao()
				: dadoNovo.getObservacao()));
		dadoAtual.setPeso((dadoAtual.getPeso().equals(dadoNovo.getPeso()) ? dadoAtual.getPeso() : dadoNovo.getPeso()));
		dadoAtual.setForca(
				(dadoAtual.getForca().equals(dadoNovo.getForca()) ? dadoAtual.getForca()
						: dadoNovo.getForca()));
		dadoAtual.setFurtividade(
				(dadoAtual.getFurtividade().equals(dadoNovo.getFurtividade()) ? dadoAtual.getFurtividade()
						: dadoNovo.getFurtividade()));

		return dadoAtual;
	}

	@Override
	public void delete(Long id) {
		Optional<Armadura> dado = repository.findById(id);

		if (!dado.isPresent()) {
			throw new AplicacaoException("Arma não existe.");
		}
		repository.deleteById(id);
	}
}
