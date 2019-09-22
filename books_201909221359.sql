create database media;

use media;

create table books (
ID int NOT NULL AUTO_INCREMENT,
title varchar(25) NOT NULL,
author varchar(35) NOT NULL,
PRIMARY KEY (ID));

INSERT INTO media.books (title,author) VALUES 
('Fahrenheit 451','Ray Bradbury')
,('World War Z','Karl Marx')
,('My Life','Bill Clinton')
,('Paradise','Rob Down')
,('Tulipomania','Mike Dash');