package com.org.house.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private int company_id;
	private String password;
	private String username;
	private boolean isEnabled;
	private boolean isAccountNonLocked;
	private boolean isAccountNonExpired;
	private boolean isCredentialsNonExpired;

	@Enumerated(EnumType.STRING)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "authority_relations ",
	joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
	inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id") })
	private Set<Authority> authorities;

}