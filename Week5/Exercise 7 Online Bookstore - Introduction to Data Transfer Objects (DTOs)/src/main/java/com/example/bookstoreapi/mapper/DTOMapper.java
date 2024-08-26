package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {

    private final ModelMapper modelMapper;

    public DTOMapper() {
        this.modelMapper = new ModelMapper();
    }

    public BookDTO toBookDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book toBookEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }
}
