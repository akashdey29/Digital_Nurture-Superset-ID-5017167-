
package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.exception.ResourceNotFoundException;
import com.example.bookstoreapi.mapper.DTOMapper;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final DTOMapper dtoMapper;

    public BookController(BookRepository bookRepository, DTOMapper dtoMapper) {
        this.bookRepository = bookRepository;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(dtoMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));
        return dtoMapper.toBookDTO(book);
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        Book book = dtoMapper.toBookEntity(bookDTO);
        book = bookRepository.save(book);
        return dtoMapper.toBookDTO(book);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book with ID " + id + " not found");
        }
        Book book = dtoMapper.toBookEntity(bookDTO);
        book.setId(id);
        book = bookRepository.save(book);
        return dtoMapper.toBookDTO(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book with ID " + id + " not found");
        }
        bookRepository.deleteById(id);
    }
}
