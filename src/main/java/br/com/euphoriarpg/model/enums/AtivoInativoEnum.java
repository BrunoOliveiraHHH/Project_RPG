package br.com.euphoriarpg.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AtivoInativoEnum {
	
	INATIVO(0),
	ATIVO(1);
	private Integer statusAtivoInativoEnum; 

}
