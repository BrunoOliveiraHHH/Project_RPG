package br.com.euphoriarpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.euphoriarpg.model.dto.UsuarioDTO;
import br.com.euphoriarpg.model.mapper.UsuarioMapper;
import br.com.euphoriarpg.model.service.UsuarioService;
import br.com.euphoriarpg.model.util.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
}