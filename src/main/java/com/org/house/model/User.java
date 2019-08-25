package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String email;
    @Column(name = "company_id")
    private long companyId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, length = 50)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owners;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "master_id")
    private Master masters;

}