package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ArmaDTO {

	private Long id;
	private String nome;
	private String custoMoeda;
	private String dadoTipoDano;
	private String peso;
	private String propriedades;
	private String observacao;
	private String usuario;
}
