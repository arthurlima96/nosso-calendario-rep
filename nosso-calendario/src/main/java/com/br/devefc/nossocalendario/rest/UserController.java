package com.br.devefc.nossocalendario.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.devefc.nossocalendario.model.Agenda;
import com.br.devefc.nossocalendario.model.User;
import com.br.devefc.nossocalendario.repository.AgendaRepository;
import com.br.devefc.nossocalendario.repository.UserRepository;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;

	@GetMapping(path = "/home")
	public String home() {
		return "Usuario logado";
	}
	
	@PostMapping(path = "/salvar")
	public ResponseEntity<UserForm> save(@Valid @RequestBody UserForm userForm) {
		User user = userForm.novoUser();
		userRepository.save(user);
		agendaRepository.save(new Agenda(user));		
		return new ResponseEntity<>(userForm, HttpStatus.OK);
	}
}
