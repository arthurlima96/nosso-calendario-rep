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

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public User(@NotBlank @NotEmpty @Email String login, @NotBlank @NotEmpty @Size(min = 6) String senha) {
		this.login = login;
		this.senha = this.encodeSenha(senha);
	}

	private String encodeSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String encodedSenha = encoder.encode(senha);
		return encodedSenha;
	}

	public Long getId() {
		return id;
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
		this.senha = this.encodeSenha(senha);
	}

	public LocalDateTime getAcesso_cadastro() {
		return acesso_cadastro;
	}
}
