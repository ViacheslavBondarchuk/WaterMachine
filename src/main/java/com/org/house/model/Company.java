package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    private long owner_id;

    private String name;

    @OneToMany
    @JoinColumn(name = "company_id")
    private Set<Master> masters;

    @OneToMany
    @JoinColumn(name = "company_id")
    private Set<User> users;

    @OneToMany
    @JoinColumn(name = "company_id")
    private Set<Automaton> automatics;

}
