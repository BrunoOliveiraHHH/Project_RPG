package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.entity.Item;

@Service
public class ItemMapper {
	
	public ItemDTO convertEntityToDto(Item dado) {
		ItemDTO dto = new ItemDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setCustoMoeda(dado.getCustoMoeda());
			dto.setDescricao(dado.getDescricao());
			dto.setPeso(dado.getPeso());
			dto.setObservacao(dado.getObservacao());
		}

		return dto;
	}

	public Item convertDtoToEntity(ItemDTO dto) {
		Item entity = new Item();

		if (dto != null) {
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setCustoMoeda(dto.getCustoMoeda());
			entity.setDescricao(dto.getDescricao());
			entity.setPeso(dto.getPeso());
			entity.setObservacao(dto.getObservacao());
		}

		return entity;
	}

	public List<ItemDTO> convertListEntityToListDto(List<Item> listaDado) {
		List<ItemDTO> listDto = new ArrayList<>();

		if (listaDado != null) {
			for (Item dado : listaDado) {
				listDto.add(convertEntityToDto(dado));
			}
		}

		return listDto;
	}

	public List<Item> convertListDtoToListEntity(List<ItemDTO> listaDto) {
		List<Item> listDado = new ArrayList<>();

		if (listaDto != null) {
			for (ItemDTO dado : listaDto) {
				listDado.add(convertDtoToEntity(dado));
			}
		}

		return listDado;
	}

}
