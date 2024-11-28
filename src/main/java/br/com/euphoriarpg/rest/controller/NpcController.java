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

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.mapper.NpcMapper;
import br.com.euphoriarpg.model.service.NpcService;
import br.com.euphoriarpg.model.util.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/npc")
public class NpcController {

	@Autowired
	private NpcService service;

	@Autowired
	private NpcMapper mapper;

	@GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<NpcDTO>> getAll() {
		List<NpcDTO> listaDto = new ArrayList<>();
		listaDto = this.mapper.convertListEntityToListDto(this.service.getAll());
		return new ResponseEntity<List<NpcDTO>>(listaDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/consulta/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<NpcDTO> getNpc(@PathVariable Long id) {
		NpcDTO dto = new NpcDTO();
		dto = this.mapper.convertEntityToDto(this.service.getById(id));
		return new ResponseEntity<NpcDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/consultaPorNome/{nome}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<NpcDTO>> getNpc(@PathVariable String nome) {
		List<NpcDTO> dto = new ArrayList<>();
		dto = this.mapper.convertListEntityToListDto(this.service.getNpcByNome(nome));
		return new ResponseEntity<List<NpcDTO>>(dto, HttpStatus.OK);
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<NpcDTO> create(@RequestBody NpcDTO dtoInput) {
		NpcDTO dto = new NpcDTO();
		dto = this.mapper.convertEntityToDto(this.service.create(dtoInput));
		return new ResponseEntity<NpcDTO>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/alterar/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<NpcDTO> update(@PathVariable Long id, @RequestBody NpcDTO dtoInput) {
		NpcDTO dto = new NpcDTO();
		dto = this.mapper.convertEntityToDto(this.service.update(id,dtoInput));
		return new ResponseEntity<NpcDTO>(dto, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/excluir/{id}")
	public ResponseEntity delete(@PathVariable Long id) {		
		service.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
