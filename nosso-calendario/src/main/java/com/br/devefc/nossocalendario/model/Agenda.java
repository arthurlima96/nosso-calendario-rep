package com.br.devefc.nossocalendario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
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
	
	public Agenda(@NotNull User user) {
		this.nome = user.getNome();
		this.setDescricao(user.getNome());
		this.dono = user;
	}
	
	private void setDescricao(@NotBlank @Size(max = 255) String descricao) {
		this.descricao =  "Agenda do(a) "+descricao;
	}
}
