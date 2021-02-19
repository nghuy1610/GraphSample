package com.huyha.graphsample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Book extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<BookAuthor> authors;
    private String price;
    private String publishedDate;
}
