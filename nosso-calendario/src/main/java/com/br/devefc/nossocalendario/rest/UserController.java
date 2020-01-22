package com.br.devefc.nossocalendario.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.devefc.nossocalendario.model.User;
import com.br.devefc.nossocalendario.repository.UserRepository;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/salvar")
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
