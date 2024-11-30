package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaDTO;
import br.com.euphoriarpg.model.entity.Arma;

@Service
public class ArmaMapper implements GenericMapper<Arma, ArmaDTO>{
	
	public List<Arma> listaEntidade;
	public List<ArmaDTO> listaDTO;
	public ArmaDTO dto;
	public Arma entidade;

	@Override
	public Arma toEntity(ArmaDTO dado) {
		entidade = new Arma();

		if (dado != null) {
			entidade.setId(dado.getId());
			entidade.setNome(dado.getNome());
			entidade.setCustoMoeda(dado.getCustoMoeda());
			entidade.setDadoTipoDano(dado.getDadoTipoDano());
			entidade.setPeso(dado.getPeso());
			entidade.setPropriedades(dado.getPropriedades());
			entidade.setObservacao(dado.getObservacao());
		}

		return entidade;
	}

	@Override
	public ArmaDTO toDto(Arma dado) {
		dto = new ArmaDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setCustoMoeda(dado.getCustoMoeda());
			dto.setDadoTipoDano(dado.getDadoTipoDano());
			dto.setPeso(dado.getPeso());
			dto.setPropriedades(dado.getPropriedades());
			dto.setObservacao(dado.getObservacao());
		}

		return dto;
	}

	@Override
	public List<Arma> toListEntity(List<ArmaDTO> listaDados) {
		listaEntidade = new ArrayList<>();

		if (listaDados != null) {
			for (ArmaDTO dado : listaDados) {
				listaEntidade.add(toEntity(dado));
			}
		}

		return listaEntidade;
	}

	@Override
	public List<ArmaDTO> toListDto(List<Arma> listaDados) {
		listaDTO = new ArrayList<>();

		if (listaDados != null) {
			for (Arma dado : listaDados) {
				listaDTO.add(toDto(dado));
			}
		}

		return listaDTO;
	}

}
