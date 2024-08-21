package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return book;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return ResponseEntity.noContent().header("Custom-Header", "Book deleted").build();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return new Book(id, "Book Title", "Author", 29.99, "ISBN1234567890");
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title, @RequestParam String author) {
        return Arrays.asList(
                new Book(1L, title, author, 29.99, "ISBN1234567890"));
    }

}
