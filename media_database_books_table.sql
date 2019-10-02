create database media;

use media;

create table user(USER_ID INT not null auto_increment,
USER_NAME VARCHAR(30) not null, primary key(USER_ID));

create table user_book_list(LIST_ID INT not null auto_increment, 
LIST_NAME varchar(30), 
USER_ID INT, 
primary key(LIST_ID), foreign key(USER_ID) references user(USER_ID));

create table books_on_list(ID int not null, 
LIST_ID int not null, 
foreign key(LIST_ID) references user_book_list(LIST_ID),
foreign key(ID) references books(ID));