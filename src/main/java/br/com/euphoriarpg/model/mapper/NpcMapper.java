package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.entity.Npc;

@Service
public class NpcMapper {

	public NpcDTO convertEntityToDto(Npc dado) {
		NpcDTO dto = new NpcDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setIdade(dado.getIdade());
			dto.setRaca(dado.getRaca());
			dto.setClasse(dado.getClasse());
		}

		return dto;
	}

	public List<NpcDTO> convertListEntityToListDto(List<Npc> listaDado) {
		List<NpcDTO> listDto = new ArrayList<>();
		NpcDTO dto;

		if (listaDado != null) {
			for (Npc dado : listaDado) {
				dto = new NpcDTO();
				dto.setId(dado.getId());
				dto.setNome(dado.getNome());
				dto.setIdade(dado.getIdade());
				dto.setRaca(dado.getRaca());
				dto.setClasse(dado.getClasse());
				listDto.add(dto);
			}
		}

		return listDto;
	}
}
