package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.euphoriarpg.model.dto.MonstroDTO;
import br.com.euphoriarpg.model.entity.Monstro;

public class MonstroMapper implements GenericMapper<Monstro, MonstroDTO> {
	
	private Monstro entidade;
	private MonstroDTO dto;
	private List<Monstro> listaEntidades;
	private List<MonstroDTO> listaDto;

	@Override
	public Monstro toEntity(MonstroDTO dado) {
		entidade = new Monstro();
		
		if(dado != null) {
			entidade.setAcoes(dado.getAcoes());
		}
		
		return entidade;
	}

	@Override
	public MonstroDTO toDto(Monstro dado) {
		dto = new MonstroDTO();
		
		if(dado!=null) {
			dto.setAcoes(dado.getAcoes());
		}
		
		return dto;
	}

	@Override
	public List<Monstro> toListEntity(List<MonstroDTO> listaDados) {
		listaEntidades = new ArrayList<>();
		
		if(!listaDados.isEmpty()) {
			for(MonstroDTO dto : listaDados) {
				listaEntidades.add(toEntity(dto));
			}
		}
		
		return listaEntidades;
	}

	@Override
	public List<MonstroDTO> toListDto(List<Monstro> listaDados) {
		listaDto = new ArrayList<>();
		
		if(!listaDados.isEmpty()) {
			for(Monstro dto : listaDados) {
				listaDto.add(toDto(dto));
			}
		}
		
		return listaDto;
	}

}
