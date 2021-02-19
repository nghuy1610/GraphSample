package com.huyha.graphsample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class BookAuthor extends BaseEntity{
    @ManyToOne
    private Book book;
    @ManyToOne
    private Author author;
}
