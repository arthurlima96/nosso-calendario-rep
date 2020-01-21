package com.br.devefc.nossocalendario.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String login;
	private String senha;
	private LocalDateTime acesso_cadastro;
	
	public User() {
	}
	
	public User(String login, String senha, LocalDateTime acesso_cadastro) {
		this.login = login;
		this.senha = senha;
		this.acesso_cadastro = acesso_cadastro;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDateTime getAcesso_cadastro() {
		return acesso_cadastro;
	}
	public void setAcesso_cadastro(LocalDateTime acesso_cadastro) {
		this.acesso_cadastro = acesso_cadastro;
	}
}
