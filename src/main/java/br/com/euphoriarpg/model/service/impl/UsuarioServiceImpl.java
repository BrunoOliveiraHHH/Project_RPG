package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.exceptions.ExceptionValidacoes;
import br.com.euphoriarpg.model.mapper.UsuarioMapper;
import br.com.euphoriarpg.model.repository.UsuarioRepository;
import br.com.euphoriarpg.model.service.LogAuditoriaService;
import br.com.euphoriarpg.model.service.UsuarioService;
import br.com.euphoriarpg.model.util.PasswordUtil;
import br.com.euphoriarpg.model.util.StringUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioMapper mapper;
	
	@Autowired
	private LogAuditoriaService logAuditoria;

	@Override
	public Usuario create(UsuarioDTO dado) {
		String nome = PasswordUtil.encryptPassword(dado.getNome());
		String anoNascimento = PasswordUtil.encryptPassword(dado.getAnoNascimento());

		Usuario entity = new Usuario(null, nome, dado.getEmail(), anoNascimento, dado.getLogin(),
				PasswordUtil.encryptPassword(dado.getSenha()));
		
		logAuditoria.insertLog(new LogAuditoria(Usuario.class.toGenericString(), null, dado.toString(),
				AcaoEnum.INSERT, LocalDateTime.now(), dado.getLogin()));

		return repository.save(entity);
	}

	@Override
	public Usuario update(Long id, UsuarioDTO dado) {
		Usuario usuarioDB = getbyLogin(dado.getLogin());

		if (usuarioDB == null) {

		}

		Usuario usuarioNew = mapper.toEntity(dado);
		usuarioNew.setId(usuarioDB.getId());

		return repository.save(usuarioNew);
	}

	@Override
	public Usuario getById(Long id) {

		Optional<Usuario> usuarioDB = repository.findById(id);

		if (usuarioDB.isEmpty()) {

		}

		return usuarioDB.get();
	}

	@Override
	public List<Usuario> getAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Usuario getbyLogin(String login) {
		return repository.getByLogin(login);
	}

	@Override
	public List<Usuario> getByNome(String nome) {

		if (StringUtils.isNullorEmpty(nome)) {
			throw new AplicacaoException(ExceptionValidacoes.NAO_HA_OBJETO_CADASTRADO);
		}

		return null;
	}

	@Override
	public void delete(Long id, String usuario) {
		repository.deleteById(id);
	}
}
