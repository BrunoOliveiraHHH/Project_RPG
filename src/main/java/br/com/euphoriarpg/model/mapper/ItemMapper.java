package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.entity.Item;

@Service
public class ItemMapper implements GenericMapper<Item, ItemDTO>{

	public List<Item> listaEntidade;
	public List<ItemDTO> listaDTO;
	public ItemDTO dto;
	public Item entidade;

	@Override
	public Item toEntity(ItemDTO dado) {
		entidade = new Item();

		if (dado != null) {
			entidade.setId(dado.getId());
			entidade.setNome(dado.getNome());
			entidade.setCustoMoeda(dado.getCustoMoeda());
			entidade.setPeso(dado.getPeso());
			entidade.setDescricao(dado.getDescricao());
			entidade.setObservacao(dado.getObservacao());
		}

		return entidade;
	}

	@Override
	public ItemDTO toDto(Item dado) {
		dto = new ItemDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setCustoMoeda(dado.getCustoMoeda());
			dto.setPeso(dado.getPeso());
			dto.setDescricao(dado.getDescricao());
			dto.setObservacao(dado.getObservacao());
		}

		return dto;
	}

	@Override
	public List<Item> toListEntity(List<ItemDTO> listaDados) {
		listaEntidade = new ArrayList<>();

		if (listaDados != null) {
			for (ItemDTO dado : listaDados) {
				listaEntidade.add(toEntity(dado));
			}
		}

		return listaEntidade;
	}

	@Override
	public List<ItemDTO> toListDto(List<Item> listaDados) {
		listaDTO = new ArrayList<>();

		if (listaDados != null) {
			for (Item dado : listaDados) {
				listaDTO.add(toDto(dado));
			}
		}

		return listaDTO;
	}
}
