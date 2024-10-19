package br.com.euphoriarpg.model.service.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.repository.UsuarioRepository;
import br.com.euphoriarpg.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario create(UsuarioDTO dado) {
		String nome = new String(Base64.decodeBase64(dado.getNome()));
		String email = new String(Base64.decodeBase64(dado.getEmail()));
		String anoNascimento = new String(Base64.decodeBase64(dado.getAnoNascimento()));
		String login = new String(Base64.decodeBase64(dado.getLogin()));
		
		Usuario entity = new Usuario(0L, nome, email, anoNascimento, login, dado.getSenha());
		
		return repository.save(entity);
	}

	@Override
	public Usuario update(UsuarioDTO dado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario listUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getbyLogin(String login) {
		return repository.getByLogin(login);
	}
}
