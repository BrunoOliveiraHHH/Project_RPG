package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.entity.Npc;

@Service
public class NpcMapper implements GenericMapper<Npc, NpcDTO> {

	public List<Npc> listaEntidade;
	public List<NpcDTO> listaDTO;
	public NpcDTO dto;
	public Npc entidade;

	@Override
	public Npc toEntity(NpcDTO dado) {
		entidade = new Npc();

		if (dado != null) {
			entidade.setId(dado.getId());
			entidade.setNome(dado.getNome());
			entidade.setIdade(dado.getIdade());
			entidade.setRaca(dado.getRaca());
			entidade.setClasse(dado.getClasse());
		}

		return entidade;
	}

	@Override
	public NpcDTO toDto(Npc dado) {
		dto = new NpcDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setIdade(dado.getIdade());
			dto.setRaca(dado.getRaca());
			dto.setClasse(dado.getClasse());
		}

		return dto;
	}

	@Override
	public List<Npc> toListEntity(List<NpcDTO> listaDados) {
		listaEntidade = new ArrayList<>();

		if (listaDados != null) {
			for (NpcDTO dado : listaDados) {
				listaEntidade.add(toEntity(dado));
			}
		}

		return listaEntidade;
	}

	@Override
	public List<NpcDTO> toListDto(List<Npc> listaDados) {
		listaDTO = new ArrayList<>();

		if (listaDados != null) {
			for (Npc dado : listaDados) {
				listaDTO.add(toDto(dado));
			}
		}

		return listaDTO;
	}

}
