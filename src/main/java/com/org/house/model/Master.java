package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Master {
    @Id
    private long user_id;

    @Column(name = "company_id")
    private long companyId;

    private String username;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(name = "master_id")
    private Set<Automaton> automatonSet;
}
