package com.library.Sociallibrary.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.Sociallibrary.Entities.Role;
import com.library.Sociallibrary.Entities.User;
import com.library.Sociallibrary.Enums.RoleEnum;
import com.library.Sociallibrary.Repositories.UserRepositiry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepositiry userRepositiry;

    public void createUser(User user) {

        user.setPassword(encriptpassword(user.getPassword()));

        if (!user.getEmail().contains("@") && !user.getEmail().contains(".")) {
            throw new RuntimeException("Email invalide");
        }

        Role roleUser = new Role();
        roleUser.setRole_name(RoleEnum.USER);
        user.setRole(roleUser);

        this.userRepositiry.save(user);
    }

    private String encriptpassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
