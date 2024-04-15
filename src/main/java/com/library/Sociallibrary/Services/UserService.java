package com.library.Sociallibrary.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.Sociallibrary.Entities.Role;
import com.library.Sociallibrary.Entities.User;
import com.library.Sociallibrary.Enums.RoleEnum;
import com.library.Sociallibrary.Repositories.UserRepositiry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepositiry userRepositiry;

    @Autowired
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepositiry userRepositiry) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepositiry = userRepositiry;
    }

    public void createUser(User user) {

        user.setPassword(encriptpassword(user.getPassword()));

        if (!user.getEmail().contains("@") && !user.getEmail().contains(".")) {
            throw new RuntimeException("Email invalide");
        }

        Optional<User> userOptional = this.userRepositiry.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new RuntimeException("Email existe ");
        }

        Role role = new Role();
        role.setLibelle(RoleEnum.USER);
        user.setRole(role);

        this.userRepositiry.save(user);
    }

    private String encriptpassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
