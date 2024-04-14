package com.library.Sociallibrary.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.Sociallibrary.Entities.User;

@Repository
public interface UserRepositiry extends CrudRepository <User, Long >{



}
