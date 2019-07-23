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
    @Column(name = "company_id")
    private long companyId;

    private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(name = "master_id")
    private Set<User> users;
}
