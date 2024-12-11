package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaduraDTO;
import br.com.euphoriarpg.model.entity.Armadura;

@Service
public class ArmaduraMapper implements GenericMapper<Armadura, ArmaduraDTO>{
	
	public List<Armadura> listaEntidade;
	public List<ArmaduraDTO> listaDTO;
	public ArmaduraDTO dto;
	public Armadura entidade;
	
	@Override
	public ArmaduraDTO toDto(Armadura dado) {
		dto = new ArmaduraDTO();

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

	@Override
	public Armadura toEntity(ArmaduraDTO dado) {
		entidade = new Armadura();

		if (dado != null) {
			entidade.setId(dado.getId());
			entidade.setNome(dado.getNome());
			entidade.setCustoMoeda(dado.getCustoMoeda());
			entidade.setClasseDeArmadura(dado.getClasseDeArmadura());
			entidade.setForca(dado.getForca());
			entidade.setFurtividade(dado.getFurtividade());
			entidade.setPeso(dado.getPeso());
			entidade.setObservacao(dado.getObservacao());
		}

		return entidade;
	}

	@Override
	public List<Armadura> toListEntity(List<ArmaduraDTO> listaDados) {
		listaEntidade = new ArrayList<>();

		if (listaDados != null) {
			for (ArmaduraDTO dado : listaDados) {
				listaEntidade.add(toEntity(dado));
			}
		}

		return listaEntidade;
	}

	@Override
	public List<ArmaduraDTO> toListDto(List<Armadura> listaDados) {
		listaDTO = new ArrayList<>();

		if (listaDados != null) {
			for (Armadura dado : listaDados) {
				listaDTO.add(toDto(dado));
			}
		}

		return listaDTO;
	}

}
