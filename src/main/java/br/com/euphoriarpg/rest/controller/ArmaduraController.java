package br.com.euphoriarpg.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.euphoriarpg.model.dto.ArmaduraDTO;
import br.com.euphoriarpg.model.mapper.ArmaduraMapper;
import br.com.euphoriarpg.model.service.ArmaduraService;
import br.com.euphoriarpg.model.util.MediaType;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/armadura")
public class ArmaduraController {

	@Autowired
	private ArmaduraService service;

	@Autowired
	private ArmaduraMapper mapper;

	@GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ArmaduraDTO>> getAll() {
		List<ArmaduraDTO> listaDto = new ArrayList<>();
		listaDto = this.mapper.toListDto(this.service.getAll());
		return new ResponseEntity<List<ArmaduraDTO>>(listaDto, HttpStatus.OK);
	}

	@GetMapping(value = "/consulta/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ArmaduraDTO> getNpc(@PathVariable Long id) {
		ArmaduraDTO dto = new ArmaduraDTO();
		dto = this.mapper.toDto(this.service.getById(id));
		return new ResponseEntity<ArmaduraDTO>(dto, HttpStatus.OK);
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ArmaduraDTO> create(@RequestBody ArmaduraDTO dtoInput) {
		ArmaduraDTO dto = new ArmaduraDTO();
		dto = this.mapper.toDto(this.service.create(dtoInput));
		return new ResponseEntity<ArmaduraDTO>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "/alterar/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ArmaduraDTO> update(@PathParam("id") Long id, @RequestBody ArmaduraDTO dtoInput) {
		ArmaduraDTO dto = new ArmaduraDTO();
		dto = this.mapper.toDto(this.service.update(id, dtoInput));
		return new ResponseEntity<ArmaduraDTO>(dto, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/excluir/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
