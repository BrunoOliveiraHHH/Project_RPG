package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;

@Service
public class UsuarioMapper implements GenericMapper<Usuario, UsuarioDTO> {

	private UsuarioDTO dto;
	private Usuario entity;

	@Override
	public UsuarioDTO toDto(Usuario entity) {
		dto = new UsuarioDTO();

		if (entity != null) {
			dto.setId(entity.getId());
			dto.setNome(entity.getNome());
			dto.setEmail(entity.getEmail());
			dto.setLogin(entity.getLogin());
			dto.setAnoNascimento(entity.getAnoNascimento());
			dto.setSenha(entity.getSenha());
		}

		return dto;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		entity = new Usuario();

		if (dto != null) {
			entity.setId(dto.getId());
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setLogin(dto.getLogin());
			entity.setAnoNascimento(dto.getAnoNascimento());
			entity.setSenha(dto.getSenha());
		}

		return entity;
	}

	@Override
	public List<Usuario> toListEntity(List<UsuarioDTO> listaDados) {
		List<Usuario> listEntity = new ArrayList<>();

		if (!listaDados.isEmpty()) {
			for (UsuarioDTO dto : listaDados) {
				listEntity.add(toEntity(dto));
			}
		}

		return listEntity;
	}

	@Override
	public List<UsuarioDTO> toListDto(List<Usuario> listaDados) {
		List<UsuarioDTO> listDto = new ArrayList<>();

		if (!listaDados.isEmpty()) {
			for (Usuario entity : listaDados) {
				listDto.add(toDto(entity));
			}
		}

		return listDto;
	}
}
