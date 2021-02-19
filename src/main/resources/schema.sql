create schema if not exists `graphql`;
set schema `graphql`;

create table author
(
    id       varchar(32) not null,
    name     varchar(64),
    birthday varchar(16),
    primary key (id)
);

create table book
(
    id            varchar(32) not null,
    name          varchar(64),
    published_date varchar(16),
    price         int(11),
    primary key (id)
);

create table book_author
(
    id         varchar(32) not null,
    book_id    varchar(32),
    author_id  varchar(32),
    primary key (id),
    constraint fk_book_author_to_book foreign key (book_id) references book(id),
    constraint fk_book_author_to_author foreign key (author_id) references author(id)
);

insert into author
values ('a1', 'author 1', '01/01/2020');
insert into book
values ('b1', 'book 1', '02/02/2020', 20000);
insert into book_author
values ('r1', 'b1', 'a1');
