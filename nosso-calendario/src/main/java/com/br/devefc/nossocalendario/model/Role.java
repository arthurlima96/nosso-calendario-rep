package com.br.devefc.nossocalendario.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	public static final Role ROLE_USER = new Role("ROLE_USER");

	private static final long serialVersionUID = -3430174216330293377L;

	@Id
	private String authority;

	/**
	 * @deprecated
	 */
	public Role () {}

	public Role(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Role role = (Role) o;
		return Objects.equals(authority, role.authority);
	}
}
