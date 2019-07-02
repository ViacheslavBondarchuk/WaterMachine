package com.org.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Email
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Automatic> automatics;
    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
    private User user;

}
