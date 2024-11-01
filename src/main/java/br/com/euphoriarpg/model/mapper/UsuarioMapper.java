package br.com.euphoriarpg.model.mapper;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;

@Service
public class UsuarioMapper {

	public UsuarioDTO toDto(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		
		if(entity != null) {
			dto.setId(entity.getId());
			dto.setNome(entity.getNome());
			dto.setEmail(entity.getEmail());
			dto.setLogin(entity.getLogin());
			dto.setAnoNascimento(entity.getAnoNascimento());
			dto.setSenha(entity.getSenha());
		}
		
		return dto;
	}
	
	public Usuario toEntity(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		
		if(dto != null) {
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setLogin(dto.getLogin());
			entity.setAnoNascimento(dto.getAnoNascimento());
			entity.setSenha(dto.getSenha());
		}
		
		return entity;
	}
}
