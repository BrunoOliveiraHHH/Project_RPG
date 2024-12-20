package br.com.euphoriarpg.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AcaoEnum {
	
	INSERT("Insert"), UPDATE("Update"), DELETE("Delete"), LOGIN("Login"), SIGN_OUT("Sign Out");
	
	private String acao;

}
