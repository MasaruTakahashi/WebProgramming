CREATE DATABASE webdb DEFAULT CHARACTER SET utf8;
use webdb;
create table user(
id SERIAL PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
login_id varchar(255) UNIQUE NOT NULL,
name varchar(255) NOT NULL,
birth_date DATE NOT NULL,
password varchar(255) NOT NULL,
create_date DATETIME NOT NULL,
update_date DATETIME NOT NULL);
select * from user;
insert into user values(1,'admin','ä«óùé“','1991-03-20','aaa',now(),now());

