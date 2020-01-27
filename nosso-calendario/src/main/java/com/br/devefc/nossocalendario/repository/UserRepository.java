package com.br.devefc.nossocalendario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.devefc.nossocalendario.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	Optional<User> findByLogin(String login);
	Optional<User> findById(Long userId);
}
