package com.library.Sociallibrary.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.Sociallibrary.Entities.User;

@Repository
public interface UserRepositiry extends JpaRepository <User, Long >{

    Optional<User> findByEmail(String email);



}
