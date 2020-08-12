package com.hpotter.bookstore.controllers;

import com.hpotter.bookstore.entities.Book;
import com.hpotter.bookstore.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BookController {

    private final BookService bookService;

    BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable Long id) {
        return this.bookService.getOne(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        return this.bookService.updateBook(id, newBook);
    }
}
