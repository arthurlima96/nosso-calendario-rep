package com.br.devefc.nossocalendario.rest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.br.devefc.nossocalendario.helpers.EncodeSenha;
import com.br.devefc.nossocalendario.model.User;

public class UserForm {

	@NotBlank(message = "Login Obrigatorio")
	@NotEmpty(message = "Login não pode ser vazio")
	@Email(message = "Email deve ser valido")
	private String login;

	@NotBlank(message = "Senha Obrigatoria")
	@NotEmpty(message = "Senha não pode ser vazia")
	@Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")
	private String senha;

	public User novoUser() {
		return new User(login, new EncodeSenha(senha));
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
}
