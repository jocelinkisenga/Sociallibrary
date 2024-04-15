package com.library.Sociallibrary.Services;

import com.library.Sociallibrary.Entities.Book;
import com.library.Sociallibrary.Repositories.BookRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book){
        this.bookRepository.save(book);

    }
    

}
