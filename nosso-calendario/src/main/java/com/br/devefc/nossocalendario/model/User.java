package com.br.devefc.nossocalendario.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Login Obrigatorio")
	@NotEmpty(message = "Login não pode ser vazio")
	@Email(message = "Email deve ser valido")
	private String login;
	
	@NotBlank(message = "Senha Obrigatoria")
	@NotEmpty(message = "Senha não pode ser vazia")
	@Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")
	private String senha;
	
	@CreationTimestamp
	private LocalDateTime acesso_cadastro;
	
	public User() {
	}
	
	public User(
			@NotBlank(message = "Login Obrigatorio")
			@NotEmpty(message = "Login não pode ser vazio")
			@Email(message = "Email deve ser valido")String login, 
			@NotBlank(message = "Senha Obrigatoria")
			@NotEmpty(message = "Senha não pode ser vazia")
			@Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")String senha) {
		this.login = login;
		this.senha = senha;
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
}
