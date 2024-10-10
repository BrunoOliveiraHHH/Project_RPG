package br.com.euphoriarpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.euphoriarpg.model.dto.AuthenticationDTO;
import br.com.euphoriarpg.model.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
}
