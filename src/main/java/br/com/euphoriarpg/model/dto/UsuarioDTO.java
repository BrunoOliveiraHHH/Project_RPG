package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String anoNascimento;
	private String login;
	private String senha;

}
