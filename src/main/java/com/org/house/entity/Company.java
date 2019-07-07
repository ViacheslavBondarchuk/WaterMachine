package com.org.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Email
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Automaton> automatics;
    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
    private User user;
    @ElementCollection
    private Collection<GrantedAuthority> grantedAuthoritiesList;

}
