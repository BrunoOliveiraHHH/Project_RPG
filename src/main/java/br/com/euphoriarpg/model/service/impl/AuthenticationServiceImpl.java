package br.com.euphoriarpg.model.service.impl;

import java.time.LocalDateTime;

import java.util.Base64;
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
	public AuthenticationDTO authentication(AuthenticationDTO dtoInput) {
		AuthenticationDTO autenticado = geraAutenticadoDescriptografado(dtoInput);
		Usuario usuario = usuarioService.getbyLogin(autenticado.getLogin());

		if (usuario != null) {
			if (usuario.getSenha().equals(PasswordUtil.encryptPassword(autenticado.getSenha()))) {
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
		} else {
			return null;
		}

		return autenticado;
	}

	private AuthenticationDTO geraAutenticadoDescriptografado(AuthenticationDTO dtoInput) {
		AuthenticationDTO autenticado = new AuthenticationDTO();
		
		byte[] loginDecodificado = Base64.getDecoder().decode(dtoInput.getLogin());
        autenticado.setLogin(new String(loginDecodificado));
        byte[] senhaDecodificada = Base64.getDecoder().decode(dtoInput.getSenha());
        autenticado.setSenha(new String(senhaDecodificada));

		return autenticado;
	}

	@Override
	public AuthenticationDTO sessaoAtiva(AuthenticationDTO dtoInput) {
		AuthenticationDTO autenticado = geraAutenticadoDescriptografado(dtoInput);
		Usuario usuario = usuarioService.getbyLogin(autenticado.getLogin());

		if (usuario != null) {
			if (usuario.getSenha().equals(PasswordUtil.encryptPassword(autenticado.getSenha()))) {
				auth = repository.getByIdAndLastRecord(autenticado.getLogin());
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

			} else {
				return null;
			}
		}

		return autenticado;
	}

	@Override
	public Boolean encerraSessao(AuthenticationDTO dtoInput) {
		Boolean autenticado = false;
		AuthenticationDTO autenticadoDTO = geraAutenticadoDescriptografado(dtoInput);
		Usuario usuario = usuarioService.getbyLogin(autenticadoDTO.getLogin());

		if (usuario != null) {
			if (usuario.getSenha().equals(PasswordUtil.encryptPassword(autenticadoDTO.getSenha()))) {
				autenticado = true;
				auth = repository.getByIdAndLastRecord(autenticadoDTO.getLogin());
				auth.setSessaoAtiva(AtivoInativoEnum.INATIVO);
				repository.save(auth);

				logAuditoria.insertLog(new LogAuditoria(Autenticacao.class.toGenericString(), null, auth.toString(),
						AcaoEnum.SIGN_OUT, LocalDateTime.now(), auth.getLogin()));

			}
		} else {
			return null;
		}

		return autenticado;
	}

}
