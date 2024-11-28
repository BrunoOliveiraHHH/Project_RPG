package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;
import br.com.euphoriarpg.model.entity.Autenticacao;
import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.enums.AtivoInativoEnum;
import br.com.euphoriarpg.model.repository.AuthenticationRepository;
import br.com.euphoriarpg.model.service.AuthenticationService;
import br.com.euphoriarpg.model.service.UsuarioService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Autenticacao auth;

	@Override
	public Boolean authentication(AuthenticationDTO dtoInput) {
		String login = new String(Base64.decodeBase64(dtoInput.getLogin()));
		String senha = new String(Base64.decodeBase64(dtoInput.getSenha()));
		Boolean autenticado = false;
		Usuario usuario = usuarioService.getbyLogin(login);

		if (usuario != null) {
			String senhaDB = new String(Base64.decodeBase64(usuario.getSenha()));
			if (senhaDB.equals(senha)) {
				autenticado = true;
				auth = new Autenticacao();
				auth.setIdUsuario(usuario.getId());
				auth.setLogin(login);
				auth.setDataValidade(LocalDateTime.now().plusHours(2));
				auth.setSessaoAtiva(AtivoInativoEnum.ATIVO);
				repository.save(auth);
			}
		}

		return autenticado;
	}

	@Override
	public Boolean sessaoAtiva(AuthenticationDTO dtoInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean encerraSessao(AuthenticationDTO dtoInput) {
		// TODO Auto-generated method stub
		return null;
	}

}
