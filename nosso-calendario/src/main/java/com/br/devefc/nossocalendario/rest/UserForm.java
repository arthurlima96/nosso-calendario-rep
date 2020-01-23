package com.br.devefc.nossocalendario.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.br.devefc.nossocalendario.helpers.EncodeSenha;
import com.br.devefc.nossocalendario.model.Agenda;
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
	
	@NotBlank(message = "Nome Obrigatorio")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	private List<AgendaForm> agendasForm = new ArrayList<>();

	public User novoUser() {
		return new User(login, new EncodeSenha(senha),nome);
	}

	public List<Agenda> novasAgendas(User user){
		return agendasForm.stream()
				.map(a -> new Agenda(user.getNome(),a.getDescricao(),user))
				.collect(Collectors.toList());
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

	public List<AgendaForm> getAgendasForm() {
		return agendasForm;
	}

	public void setAgendasForm(List<AgendaForm> agendasForm) {
		this.agendasForm = agendasForm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
