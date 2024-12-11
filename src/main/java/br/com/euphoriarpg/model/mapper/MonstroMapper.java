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
			entidade.setAcoeslendarias(dado.getAcoeslendarias());
			entidade.setAcoesmiticas(dado.getAcoesmiticas());
			entidade.setBp(dado.getBp());
			entidade.setCa(dado.getCa());
			entidade.setCaracteristicas(dado.getCaracteristicas());
			entidade.setCha(dado.getCha());
			entidade.setCon(dado.getCon());
			entidade.setDesloc_e(dado.getDesloc_e());
			entidade.setDesloc_n(dado.getDesloc_n());
			entidade.setDesloc_s(dado.getDesloc_s());
			entidade.setDesloc_t(dado.getDesloc_t());
			entidade.setDesloc_v(dado.getDesloc_v());
			entidade.setDex(dado.getDex());
			entidade.setHp(dado.getHp());
			entidade.setId(dado.getId());
			entidade.setInte(dado.getInte());
			entidade.setNd(dado.getNd());
			entidade.setNome(dado.getNome());
			entidade.setStr(dado.getStr());
			entidade.setTamanho(dado.getTamanho());
			entidade.setTendencia(dado.getTendencia());
			entidade.setTipo(dado.getTipo());
			entidade.setTracos(dado.getTracos());
			entidade.setWis(dado.getWis());
		}
		
		return entidade;
	}

	@Override
	public MonstroDTO toDto(Monstro dado) {
		dto = new MonstroDTO();
		
		if(dado!=null) {
			dto.setAcoes(dado.getAcoes());
			dto.setAcoeslendarias(dado.getAcoeslendarias());
			dto.setAcoesmiticas(dado.getAcoesmiticas());
			dto.setBp(dado.getBp());
			dto.setCa(dado.getCa());
			dto.setCaracteristicas(dado.getCaracteristicas());
			dto.setCha(dado.getCha());
			dto.setCon(dado.getCon());
			dto.setDesloc_e(dado.getDesloc_e());
			dto.setDesloc_n(dado.getDesloc_n());
			dto.setDesloc_s(dado.getDesloc_s());
			dto.setDesloc_t(dado.getDesloc_t());
			dto.setDesloc_v(dado.getDesloc_v());
			dto.setDex(dado.getDex());
			dto.setHp(dado.getHp());
			dto.setId(dado.getId());
			dto.setInte(dado.getInte());
			dto.setNd(dado.getNd());
			dto.setNome(dado.getNome());
			dto.setStr(dado.getStr());
			dto.setTamanho(dado.getTamanho());
			dto.setTendencia(dado.getTendencia());
			dto.setTipo(dado.getTipo());
			dto.setTracos(dado.getTracos());
			dto.setWis(dado.getWis());
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
