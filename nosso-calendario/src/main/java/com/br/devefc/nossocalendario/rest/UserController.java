package com.br.devefc.nossocalendario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.devefc.nossocalendario.model.User;
import com.br.devefc.nossocalendario.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/salvar")
	public ResponseEntity<User> save(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
