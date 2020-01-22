package com.br.devefc.nossocalendario.helpers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeSenha {
	
	private String senha;
	
	public EncodeSenha(@NotBlank @NotEmpty @Size(min = 6)String senha) {
		this.senha = senha;
	}

	public String encodeSenha() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		return encoder.encode(this.senha);
	}
}
