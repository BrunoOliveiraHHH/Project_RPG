package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;
import br.com.euphoriarpg.model.entity.Autenticacao;
import br.com.euphoriarpg.model.entity.LogAuditoria;
import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.enums.AcaoEnum;
import br.com.euphoriarpg.model.enums.AtivoInativoEnum;
import br.com.euphoriarpg.model.repository.AuthenticationRepository;
import br.com.euphoriarpg.model.service.AuthenticationService;
import br.com.euphoriarpg.model.service.LogAuditoriaService;
import br.com.euphoriarpg.model.service.UsuarioService;
import br.com.euphoriarpg.model.util.PasswordUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LogAuditoriaService logAuditoria;
	
	private Autenticacao auth;

	@Override
	public Boolean authentication(AuthenticationDTO dtoInput) {
		Boolean autenticado = false;
		Usuario usuario = usuarioService.getbyLogin(dtoInput.getLogin());

		if (usuario != null) {
			if (usuario.getSenha().equals(PasswordUtil.encryptPassword(dtoInput.getSenha()))) {
				autenticado = true;
				auth = new Autenticacao();
				auth.setIdUsuario(usuario.getId());
				auth.setLogin(dtoInput.getLogin());
				auth.setDataLogin(LocalDateTime.now());
				auth.setDataValidade(LocalDateTime.now().plusHours(3));
				auth.setSessaoAtiva(AtivoInativoEnum.ATIVO);
				
				logAuditoria.insertLog(new LogAuditoria(Autenticacao.class.toGenericString(), null, auth.toString(),
						AcaoEnum.LOGIN, LocalDateTime.now(), auth.getLogin()));
				
				repository.save(auth);
			}
		}

		return autenticado;
	}

	@Override
	public Boolean sessaoAtiva(AuthenticationDTO dtoInput) {
		Boolean autenticado = false;
		Usuario usuario = usuarioService.getbyLogin(dtoInput.getLogin());

		if (usuario != null) {
			if (usuario.getSenha().equals(PasswordUtil.encryptPassword(dtoInput.getSenha()))) {
				autenticado = true;
				auth = repository.getByIdAndLastRecord(dtoInput.getLogin());
				auth.setSessaoAtiva(AtivoInativoEnum.INATIVO);
				
				logAuditoria.insertLog(new LogAuditoria(Autenticacao.class.toGenericString(), null, auth.toString(),
						AcaoEnum.SIGN_OUT, LocalDateTime.now(), auth.getLogin()));
				
				repository.save(auth);
				
				auth.setId(null);
				auth.setSessaoAtiva(AtivoInativoEnum.ATIVO);
				auth.setDataLogin(LocalDateTime.now());
				auth.setDataValidade(LocalDateTime.now().plusHours(3));
				
				logAuditoria.insertLog(new LogAuditoria(Autenticacao.class.toGenericString(), null, auth.toString(),
						AcaoEnum.LOGIN, LocalDateTime.now(), auth.getLogin()));
				
				repository.save(auth);
			}
		}

		return autenticado;
	}

	@Override
	public Boolean encerraSessao(AuthenticationDTO dtoInput) {
		Boolean autenticado = false;
		Usuario usuario = usuarioService.getbyLogin(dtoInput.getLogin());

		if (usuario != null) {
			if (usuario.getSenha().equals(PasswordUtil.encryptPassword(dtoInput.getSenha()))) {
				autenticado = true;
				auth = repository.getByIdAndLastRecord(dtoInput.getLogin());
				auth.setSessaoAtiva(AtivoInativoEnum.INATIVO);
				repository.save(auth);		
				
				logAuditoria.insertLog(new LogAuditoria(Autenticacao.class.toGenericString(), null, auth.toString(),
						AcaoEnum.SIGN_OUT, LocalDateTime.now(), auth.getLogin()));
				
			}
		}

		return autenticado;
	}

}
