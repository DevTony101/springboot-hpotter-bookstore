package com.hpotter.bookstore.services;

import com.hpotter.bookstore.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getOne(Long id);
    Book updateBook(Long id, Book newBook);
    void createRecords();
}
