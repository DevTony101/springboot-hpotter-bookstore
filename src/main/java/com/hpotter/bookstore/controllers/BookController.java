package com.hpotter.bookstore.controllers;

import com.hpotter.bookstore.entities.Book;
import com.hpotter.bookstore.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
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
