package br.com.euphoriarpg.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.mapper.UsuarioMapper;
import br.com.euphoriarpg.model.service.UsuarioService;
import br.com.euphoriarpg.model.util.MediaType;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioMapper mapper;
	
	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dtoInput) {
		UsuarioDTO dto = new UsuarioDTO();
		dto = this.mapper.toDto(this.service.create(dtoInput));
		return new ResponseEntity<UsuarioDTO>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/consultar/{nome}", produces= MediaType.APPLICATION_JSON)
	public ResponseEntity<List<UsuarioDTO>> consultarPorNome(@PathVariable String nome){
		List<UsuarioDTO> dto = new ArrayList<>();
		dto = this.mapper.toListDto(this.service.getByNome(nome));
		return new ResponseEntity<List<UsuarioDTO>>(dto, HttpStatus.OK);
	}
}
