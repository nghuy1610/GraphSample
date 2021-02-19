package com.huyha.graphsample.mapper;

import com.huyha.graphsample.entity.BookAuthor;
import com.huyha.graphsample.schema.AuthorDto;
import org.modelmapper.PropertyMap;

public class BookAuthorToAuthorDto extends PropertyMap<BookAuthor, AuthorDto> {
    @Override
    protected void configure() {
        map(source.getAuthor().getName(), destination.getName());
        map(source.getAuthor().getBirthday(), destination.getBirthday());
    }
}
