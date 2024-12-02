package br.com.euphoriarpg.model.service;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;

public interface AuthenticationService {

	AuthenticationDTO authentication(AuthenticationDTO dtoInput);

	AuthenticationDTO sessaoAtiva(AuthenticationDTO dtoInput);

	Boolean encerraSessao(AuthenticationDTO dtoInput);

}
