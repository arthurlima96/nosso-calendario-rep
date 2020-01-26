package com.br.devefc.nossocalendario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.devefc.nossocalendario.model.User;
import com.br.devefc.nossocalendario.repository.UserRepository;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository; 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> possibleUser = userRepository.findByLogin(username);
		return possibleUser.orElseThrow(
				() -> new UsernameNotFoundException("Não foi possível encontrar usuário com email: " + username));
	}

	public UserDetails loadUserById(Long userId) {
		
		Optional<User> possibleUser = userRepository.findById(userId);
		return possibleUser.orElseThrow(
				() -> new UsernameNotFoundException("Não foi possível encontrar o usuário com id: " + userId));
	}

}