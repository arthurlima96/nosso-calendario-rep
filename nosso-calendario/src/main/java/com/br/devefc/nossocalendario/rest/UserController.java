package com.br.devefc.nossocalendario.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.devefc.nossocalendario.repository.UserRepository;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/salvar")
	public ResponseEntity<UserForm> save(@Valid @RequestBody UserForm user) {
		userRepository.save(user.novoUser());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
