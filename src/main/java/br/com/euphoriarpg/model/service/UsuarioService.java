package br.com.euphoriarpg.model.service;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;

@Service
public interface UsuarioService {
	
	Usuario create(UsuarioDTO dado);
	
	Usuario update(UsuarioDTO dado);
	
	Usuario getUsuario(Long id);
	
	Usuario listUsuario();
	
	Usuario deleteUsuario(Long id);
	
	Usuario getbyLogin(String login);

}
