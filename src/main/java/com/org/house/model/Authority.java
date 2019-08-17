package com.org.house.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    USER, MASTER, OWNER, ADMIN;

    @Override
    public String toString() {
        return name();
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
