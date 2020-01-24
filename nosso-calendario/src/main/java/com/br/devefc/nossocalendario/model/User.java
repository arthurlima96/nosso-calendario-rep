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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.br.devefc.nossocalendario.helpers.EncodeSenha;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Email
	private String login;

	@NotBlank
	@Size(min = 6)
	private String senha;
	
	@NotBlank
	private String nome;

	private LocalDateTime acesso_cadastro  = LocalDateTime.now();

	public User() {
	}

	public User(@NotBlank @Email String login,EncodeSenha senha,@NotBlank String nome) {
		this.login = login;
		this.senha = senha.encodeSenha();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}
	
	public String getNome(){
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getAcesso_cadastro() {
		return acesso_cadastro;
	}
}
