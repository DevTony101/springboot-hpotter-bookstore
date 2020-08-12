package com.hpotter.bookstore.services;

import com.hpotter.bookstore.entities.Book;
import com.hpotter.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IBookService implements BookService {

    private final BookRepository repository;

    IBookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(this.repository.findAll());
    }

    @Override
    public Book getOne(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(Long id, Book newBook) {
        return this.repository.findById(id).map(book -> {
            book.setTitle(newBook.getTitle());
            book.setDescription(newBook.getDescription());
            book.setPrice(newBook.getPrice());
            book.setQuantity(newBook.getQuantity());
            book.setCover(newBook.getCover());
            return repository.save(book);
        }).orElse(null);
    }
}
