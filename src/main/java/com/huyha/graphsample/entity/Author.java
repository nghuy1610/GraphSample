package com.huyha.graphsample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Author extends BaseEntity{
    private String name;
    private String birthday;
}
