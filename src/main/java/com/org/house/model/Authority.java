package com.org.house.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
@Entity
public enum Authority implements GrantedAuthority {
	USER, ADMIN;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToMany(mappedBy = "authorities")
	private Set<User> user;

	@Override
	public String toString() {
		return name();
	}

	@Override
	public String getAuthority() {
		return name();
	}

}
