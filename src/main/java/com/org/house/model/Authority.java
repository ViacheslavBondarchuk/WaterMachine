package com.org.house.model;

import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
public enum Authority implements GrantedAuthority {
    USER, MASTER, OWNER, ADMIN;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<User> user;

    @Override
    public String getAuthority() {
        return name();
    }

}
