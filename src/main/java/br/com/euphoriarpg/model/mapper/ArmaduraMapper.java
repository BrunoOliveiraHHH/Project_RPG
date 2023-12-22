package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaduraDTO;
import br.com.euphoriarpg.model.entity.Armadura;

@Service
public class ArmaduraMapper {
	
	public ArmaduraDTO convertEntityToDto(Armadura dado) {
		ArmaduraDTO dto = new ArmaduraDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setCustoMoeda(dado.getCustoMoeda());
			dto.setClasseDeArmadura(dado.getClasseDeArmadura());
			dto.setForca(dado.getForca());
			dto.setFurtividade(dado.getFurtividade());
			dto.setPeso(dado.getPeso());
			dto.setObservacao(dado.getObservacao());
		}

		return dto;
	}

	public Armadura convertDtoToEntity(ArmaduraDTO dto) {
		Armadura entity = new Armadura();

		if (dto != null) {
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setCustoMoeda(dto.getCustoMoeda());
			entity.setClasseDeArmadura(dto.getClasseDeArmadura());
			entity.setForca(dto.getForca());
			entity.setFurtividade(dto.getFurtividade());
			entity.setPeso(dto.getPeso());
			entity.setObservacao(dto.getObservacao());
		}

		return entity;
	}

	public List<ArmaduraDTO> convertListEntityToListDto(List<Armadura> listaDado) {
		List<ArmaduraDTO> listDto = new ArrayList<>();

		if (listaDado != null) {
			for (Armadura dado : listaDado) {
				listDto.add(convertEntityToDto(dado));
			}
		}

		return listDto;
	}

	public List<Armadura> convertListDtoToListEntity(List<ArmaduraDTO> listaDto) {
		List<Armadura> listDado = new ArrayList<>();

		if (listaDto != null) {
			for (ArmaduraDTO dado : listaDto) {
				listDado.add(convertDtoToEntity(dado));
			}
		}

		return listDado;
	}

}
