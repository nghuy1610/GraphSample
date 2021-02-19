package com.huyha.graphsample.service;

import com.huyha.graphsample.entity.Book;
import com.huyha.graphsample.mapper.Mapper;
import com.huyha.graphsample.repository.BookRepository;
import com.huyha.graphsample.schema.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FetcherService {
    private final Mapper mapper;
    private final BookRepository bookRepository;

    public BookDto findBookByName(String name) {
        Book book = bookRepository.findByName(name);
        return mapper.map(book, BookDto.class);
    }
}
