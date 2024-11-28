package br.com.euphoriarpg.model.repository.specifications;

import java.util.List;

import br.com.euphoriarpg.model.entity.Usuario;

public interface UsuarioRepositoryCustom {
	
	List<Usuario> findUsuario(String nome);

}
