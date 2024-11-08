package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemDTO {
	
	private Long id;
	private String nome;
	private String custoMoeda;
	private String descricao;	
	private String peso;
	private String observacao;
	
}
