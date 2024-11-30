package br.com.euphoriarpg.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.entity.Usuario;

@Service
public class UsuarioMapper implements GenericMapper<Usuario, UsuarioDTO> {

	private UsuarioDTO dto;
	private Usuario entidade;
	private List<Usuario> listaEntidade;
	private List<UsuarioDTO> listaDTO;

	@Override
	public UsuarioDTO toDto(Usuario dado) {
		dto = new UsuarioDTO();

		if (dado != null) {
			dto.setId(dado.getId());
			dto.setNome(dado.getNome());
			dto.setEmail(dado.getEmail());
			dto.setLogin(dado.getLogin());
			dto.setAnoNascimento(dado.getAnoNascimento());
			dto.setSenha(dado.getSenha());
		}

		return dto;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dado) {
		entidade = new Usuario();

		if (dado != null) {
			entidade.setId(dado.getId());
			entidade.setNome(dado.getNome());
			entidade.setEmail(dado.getEmail());
			entidade.setLogin(dado.getLogin());
			entidade.setAnoNascimento(dado.getAnoNascimento());
			entidade.setSenha(dado.getSenha());
		}

		return entidade;
	}

	@Override
	public List<Usuario> toListEntity(List<UsuarioDTO> listaDados) {
		listaEntidade = new ArrayList<>();

		if (!listaDados.isEmpty()) {
			for (UsuarioDTO dto : listaDados) {
				listaEntidade.add(toEntity(dto));
			}
		}

		return listaEntidade;
	}

	@Override
	public List<UsuarioDTO> toListDto(List<Usuario> listaDados) {
		listaDTO = new ArrayList<>();

		if (!listaDados.isEmpty()) {
			for (Usuario entity : listaDados) {
				listaDTO.add(toDto(entity));
			}
		}

		return listaDTO;
	}
}
