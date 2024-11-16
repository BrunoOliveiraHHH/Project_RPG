package br.com.euphoriarpg.model.service;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;

public interface AuthenticationService {

	Boolean authentication(AuthenticationDTO dtoInput);
	
	Boolean sessaoAtiva(AuthenticationDTO dtoInput);
	
	Boolean encerraSessao(AuthenticationDTO dtoInput);

}
