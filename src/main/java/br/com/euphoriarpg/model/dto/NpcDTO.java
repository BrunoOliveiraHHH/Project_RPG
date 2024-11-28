package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NpcDTO {

	private Long id;
	private String nome;
	private String idade;
	private String raca;
	private String classe;

}
