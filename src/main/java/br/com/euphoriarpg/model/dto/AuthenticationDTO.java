package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthenticationDTO {

	private String login;
	private String senha;

}
