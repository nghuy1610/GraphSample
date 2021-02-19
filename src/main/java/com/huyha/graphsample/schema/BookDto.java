package com.huyha.graphsample.schema;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private String name;
    private List<AuthorDto> authors;
    private String price;
    private String publishedDate;
}
