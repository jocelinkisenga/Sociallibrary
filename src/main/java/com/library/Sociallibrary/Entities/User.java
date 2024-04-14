package com.library.Sociallibrary.Entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String password;
    private String name;
    private String email;
    private Boolean status = false;
    @OneToOne(cascade = CascadeType.ALL)
    private final Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status;
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }

    

}
