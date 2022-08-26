--liquibase formatted sql

--changeset thn:id1
create table category
(
    id   bigint primary key not null,
    name varchar            not null
);

create table pet
(
    id          bigint primary key not null,
    category_id bigint references category (id) on delete cascade on update cascade,
    name        varchar            not null,
    user_status varchar(9)         not null
);

create table orders
(
    id           bigserial primary key,
    pet_id       bigint references pet (id) not null,
    quantity     int                        not null,
    date_time    date                       not null,
    order_status varchar(9)                 not null,
    is_complete  bool                       not null
);

create table users
(
    id          bigserial primary key,
    username    varchar not null,
    firstname   varchar,
    lastname    varchar,
    email       varchar,
    pass        varchar not null,
    phone       varchar,
    user_status varchar
);

create sequence seq1 as BIGINT start with 70 increment 2 owned by category.id;
create sequence seq2 as BIGINT start with 1 increment 1 owned by pet.id;
--rollback
-- drop table category;
-- drop table pet;
-- drop table orders;
-- drop table users;
-- drop sequence seq1;
-- drop sequence seq2;

