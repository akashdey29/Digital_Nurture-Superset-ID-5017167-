package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        return Arrays.asList(
                new Book(1L, "Book Title 1", "Author 1", 29.99, "ISBN1234567890"),
                new Book(2L, "Book Title 2", "Author 2", 39.99, "ISBN0987654321"));
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        // Simulate deletion
    }
}
