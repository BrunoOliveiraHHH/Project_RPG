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

import br.com.euphoriarpg.model.dto.ArmaDTO;
import br.com.euphoriarpg.model.mapper.ArmaMapper;
import br.com.euphoriarpg.model.service.ArmaService;
import br.com.euphoriarpg.model.util.MediaType;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/arma")
public class ArmaController {

	@Autowired
	private ArmaService service;

	@Autowired
	private ArmaMapper mapper;

	@GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ArmaDTO>> getAll() {
		List<ArmaDTO> listaDto = new ArrayList<>();
		listaDto = this.mapper.toListDto(this.service.getAll());
		return new ResponseEntity<List<ArmaDTO>>(listaDto, HttpStatus.OK);
	}

	@GetMapping(value = "/consulta/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ArmaDTO> getNpc(@PathVariable Long id) {
		ArmaDTO dto = new ArmaDTO();
		dto = this.mapper.toDto(this.service.getById(id));
		return new ResponseEntity<ArmaDTO>(dto, HttpStatus.OK);
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ArmaDTO> create(@RequestBody ArmaDTO dtoInput) {
		ArmaDTO dto = new ArmaDTO();
		dto = this.mapper.toDto(this.service.create(dtoInput));
		return new ResponseEntity<ArmaDTO>(dto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/alterar/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ArmaDTO> update(@PathParam("id") Long id, @RequestBody ArmaDTO dtoInput) {
		ArmaDTO dto = new ArmaDTO();
		dto = this.mapper.toDto(this.service.update(id,dtoInput));
		return new ResponseEntity<ArmaDTO>(dto, HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/excluir/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
