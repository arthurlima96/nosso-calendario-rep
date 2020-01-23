package com.br.devefc.nossocalendario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String descricao;
	
	@NotNull
	@ManyToOne
	private User dono;
	
	public Agenda() {
	}

	public Agenda(@NotNull @NotEmpty String nome, @NotNull @NotEmpty @Size(max = 255) String descricao,
			@NotNull User dono) {
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public User getDono() {
		return dono;
	}
	
	
}
