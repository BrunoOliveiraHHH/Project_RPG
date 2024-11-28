package br.com.euphoriarpg.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaDTO;
import br.com.euphoriarpg.model.entity.Arma;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.mapper.ArmaMapper;
import br.com.euphoriarpg.model.repository.ArmaRepository;
import br.com.euphoriarpg.model.service.ArmaService;

@Service
public class ArmaServiceImpl implements ArmaService {

	@Autowired
	private ArmaRepository repository;

	@Autowired
	private ArmaMapper mapper;

	@Override
	public List<Arma> getAll() {
		List<Arma> listaDados = repository.findAll();

		if (listaDados == null) {
			return new ArrayList<>();
		}

		return listaDados;
	}

	@Override
	public Arma getById(Long id) {
		Optional<Arma> dado = repository.findById(id);

		if (!dado.isPresent()) {
			return new Arma();
		}

		return dado.get();
	}

	@Override
	public Arma create(ArmaDTO dto) {
		Arma dado = repository.getArma(dto.getNome());

		if (dado != null) {
			return new Arma();
		}

		dado = mapper.toEntity(dto);

		return repository.save(dado);
	}

	@Override
	public Arma update(Long id, ArmaDTO dto) {
		Arma dadoAtual = repository.getArma(dto.getNome());

		if (dadoAtual == null) {
			return new Arma();
		}

		Arma dadoNovo = mapper.toEntity(dto);

		dadoNovo = this.validaCamposUpdate(dadoAtual, dadoNovo);

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

		if (!dado.isPresent()) {
			throw new AplicacaoException("Arma não existe.");
		}
		repository.deleteById(id);
	}

}
