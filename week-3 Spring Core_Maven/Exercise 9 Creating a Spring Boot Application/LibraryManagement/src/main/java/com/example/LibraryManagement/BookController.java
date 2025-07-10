package com.example.LibraryManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // POST create new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // GET single book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // DELETE book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
