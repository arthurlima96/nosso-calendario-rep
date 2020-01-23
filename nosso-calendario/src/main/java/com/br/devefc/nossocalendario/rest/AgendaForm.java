package com.br.devefc.nossocalendario.rest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.devefc.nossocalendario.model.Agenda;
import com.br.devefc.nossocalendario.model.User;

public class AgendaForm {

	@NotNull(message = " O nome não pode ser nulo")
	@NotEmpty(message = " O nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = " A descrição não pode ser nula")
	@NotEmpty(message = " A descrição não pode ser vazia")
	@Size(max = 255, message = "A descricao deve ter no maximo 255 caracteres")
	private String descricao;
		
	public Agenda novaAgenda(User user) {
		return new Agenda(user.getNome(), descricao,user);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
