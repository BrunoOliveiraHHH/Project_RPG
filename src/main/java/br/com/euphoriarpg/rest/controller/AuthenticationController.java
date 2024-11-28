package br.com.euphoriarpg.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;
import br.com.euphoriarpg.model.service.AuthenticationService;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;

	@PostMapping(value = "/autenticar")
	public ResponseEntity<Boolean> authentication(@RequestBody AuthenticationDTO dtoInput) {
		Boolean autenticado = service.authentication(dtoInput);
		return new ResponseEntity<Boolean>(autenticado, HttpStatus.OK);
	}
	
	@PostMapping(value="/encerra-sessao")
	public ResponseEntity<Boolean> encerraSessao(@RequestBody AuthenticationDTO dtoInput){
		Boolean encerrado = false;		
		return new ResponseEntity<Boolean>(encerrado, HttpStatus.OK);
	}
	
	@PostMapping(value="/sessao-ativa")
	public ResponseEntity<Boolean> sessaoAtiva(@RequestBody AuthenticationDTO dtoInput){
		Boolean ativa = false;		
		return new ResponseEntity<Boolean>(ativa, HttpStatus.OK);
	}
}
