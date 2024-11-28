package br.com.euphoriarpg.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;

@Service
public interface UsuarioService extends GenericService<Usuario, UsuarioDTO>{
		
	Usuario getbyLogin(String login);
	
	List<Usuario> getByNome(String nome);

}
