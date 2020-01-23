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
	
	@NotNull(message = " O dono não pode ser nulo")
	private User dono;
	
	public Agenda novaAgenda() {
		return new Agenda(nome, descricao, dono);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public User getDono() {
		return dono;
	}

	public void setDono(User dono) {
		this.dono = dono;
	}
	
	
}
