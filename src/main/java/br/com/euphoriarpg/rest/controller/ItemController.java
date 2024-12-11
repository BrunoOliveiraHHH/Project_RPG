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

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.mapper.ItemMapper;
import br.com.euphoriarpg.model.service.ItemService;
import br.com.euphoriarpg.model.util.MediaType;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@Autowired
	private ItemMapper mapper;

	@GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ItemDTO>> getAll() {
		List<ItemDTO> listaDto = new ArrayList<>();
		listaDto = this.mapper.toListDto(this.service.getAll());
		return new ResponseEntity<List<ItemDTO>>(listaDto, HttpStatus.OK);
	}

	@GetMapping(value = "/consulta/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ItemDTO> getNpc(@PathVariable Long id) {
		ItemDTO dto = new ItemDTO();
		dto = this.mapper.toDto(this.service.getById(id));
		return new ResponseEntity<ItemDTO>(dto, HttpStatus.OK);
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO dtoInput) {
		ItemDTO dto = new ItemDTO();
		dto = this.mapper.toDto(this.service.create(dtoInput));
		return new ResponseEntity<ItemDTO>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "/alterar/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<ItemDTO> update(@PathVariable Long id, @RequestBody ItemDTO dtoInput) {
		ItemDTO dto = new ItemDTO();
		dto = this.mapper.toDto(this.service.update(id, dtoInput));
		return new ResponseEntity<ItemDTO>(dto, HttpStatus.OK);
	}

	
	@GetMapping(value = "/excluir/{id},{usuario}")
	public void delete(@PathVariable Long id, @PathVariable String usuario) {
		service.delete(id,usuario);
	}
}
