package com.br.devefc.nossocalendario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.devefc.nossocalendario.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

}
