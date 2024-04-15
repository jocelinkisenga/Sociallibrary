package com.library.Sociallibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.Sociallibrary.Entities.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
