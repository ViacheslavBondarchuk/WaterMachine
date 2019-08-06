package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name = "company_id")
    private long companyId;
    private String password;
    private String username;
    private boolean isMaster;
    private boolean isOwner;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;

    @Enumerated(EnumType.STRING)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authority_relations ",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owners;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "master_id")
    private Master masters;

}