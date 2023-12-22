package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaDTO;
import br.com.euphoriarpg.model.entity.Arma;

@Service
public class ArmaMapper {

	public ArmaDTO convertEntityToDto(Arma dado) {
		ArmaDTO dto = new ArmaDTO();

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

	public Arma convertDtoToEntity(ArmaDTO dto) {
		Arma entity = new Arma();

		if (dto != null) {
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setCustoMoeda(dto.getCustoMoeda());
			entity.setDadoTipoDano(dto.getDadoTipoDano());
			entity.setPeso(dto.getPeso());
			entity.setPropriedades(dto.getPropriedades());
			entity.setObservacao(dto.getObservacao());
		}

		return entity;
	}

	public List<ArmaDTO> convertListEntityToListDto(List<Arma> listaDado) {
		List<ArmaDTO> listDto = new ArrayList<>();

		if (listaDado != null) {
			for (Arma dado : listaDado) {
				listDto.add(convertEntityToDto(dado));
			}
		}

		return listDto;
	}

	public List<Arma> convertListDtoToListEntity(List<ArmaDTO> listaDto) {
		List<Arma> listDado = new ArrayList<>();

		if (listaDto != null) {
			for (ArmaDTO dado : listaDto) {
				listDado.add(convertDtoToEntity(dado));
			}
		}

		return listDado;
	}

}
