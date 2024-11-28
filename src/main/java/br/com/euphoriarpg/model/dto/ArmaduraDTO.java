package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ArmaduraDTO {

	private Long id;
	private String nome;
	private String custoMoeda;
	private String classeDeArmadura;
	private String forca;
	private String furtividade;
	private String peso;
	private String observacao;

}
