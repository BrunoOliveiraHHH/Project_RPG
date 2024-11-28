package br.com.euphoriarpg.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.UsuarioMapper;
import br.com.euphoriarpg.model.repository.UsuarioRepository;
import br.com.euphoriarpg.model.service.UsuarioService;
import br.com.euphoriarpg.model.util.StringUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;

	@Override
	public Usuario create(UsuarioDTO dado) {
		String nome = new String(Base64.decodeBase64(dado.getNome()));
		String email = new String(Base64.decodeBase64(dado.getEmail()));
		String anoNascimento = new String(Base64.decodeBase64(dado.getAnoNascimento()));
		String login = new String(Base64.decodeBase64(dado.getLogin()));
		
		Usuario entity = new Usuario(null, nome, email, anoNascimento, login, dado.getSenha());
		
		return repository.save(entity);
	}

	@Override
	public Usuario update(Long id, UsuarioDTO dado) {
		Usuario usuarioDB = getbyLogin(dado.getLogin());
		
		if(usuarioDB == null) {
			
		}
		
		Usuario usuarioNew = mapper.toEntity(dado);
		usuarioNew.setId(usuarioDB.getId());
		
		return repository.save(usuarioNew);
	}

	@Override
	public Usuario getById(Long id) {
		
		Optional<Usuario> usuarioDB = repository.findById(id);
			
		if(usuarioDB.isEmpty()) {
			
		}
		
		return usuarioDB.get();
	}

	@Override
	public List<Usuario> getAll() {		
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public Usuario getbyLogin(String login) {
		return repository.getByLogin(login);
	}

	@Override
	public List<Usuario> getByNome(String nome) {	
		
		if(StringUtils.isNullorEmpty(nome)) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}
		
		return null;
	}
}
