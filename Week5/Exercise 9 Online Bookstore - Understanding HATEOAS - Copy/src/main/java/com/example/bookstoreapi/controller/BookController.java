package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.mapper.DTOMapper;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final DTOMapper dtoMapper;

    public BookController(BookRepository bookRepository, DTOMapper dtoMapper) {
        this.bookRepository = bookRepository;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/paged")
    public Page<BookDTO> getAllBooksPaged(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookRepository.findAll(pageable).map(dtoMapper::toBookDTO);
    }
}
