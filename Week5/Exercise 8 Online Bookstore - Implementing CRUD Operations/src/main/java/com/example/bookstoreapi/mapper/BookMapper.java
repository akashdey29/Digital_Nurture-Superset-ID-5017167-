package com.example.bookstoreapi.mapper;



import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}
