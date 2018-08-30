CREATE DATABASE User_Management DEFAULT CHARACTER SET utf8;

USE User_Management;

 CREATE TABLE user(id SERIAL,login_id varchar(255) UNIQUE NOT NULL,name varchar(255) NOT NULL,birth_date DATE NOT NULL,password varchar(255) NOT NULL,create_date DATETIME NOT NULL,update_date DATETIME NOT NULL);

INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES('admin','ä«óùé“','2000-01-01','abcdefg','1111-11-11 11:11:11',now());