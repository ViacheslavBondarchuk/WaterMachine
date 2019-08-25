package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Master {
    @Id
    private long user_id;

    @Column(name = "company_id")
    private long companyId;

    private String username;
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "master_id")
    private Set<Automaton> automatons;
}
