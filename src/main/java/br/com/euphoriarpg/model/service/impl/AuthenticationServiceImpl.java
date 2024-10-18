package br.com.euphoriarpg.model.service.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;
import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.service.AuthenticationService;
import br.com.euphoriarpg.model.service.UsuarioService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UsuarioService usuarioService;

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
			}
		}

		return autenticado;
	}

}
