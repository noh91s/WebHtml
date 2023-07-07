show databases;
-- mysql06 사용 
use mysql06;
-- DB테이블 조회
show tables;
drop tables if exists member0705;
create table member0705(
	member_id bigint not null auto_increment,
    name varchar(45) not null,
    password varchar(45) not null,
    email varchar(100) not null unique,
    phone varchar(100) not null,
    address varchar(255) not null,
    grade varchar(45) default 'MEMBER',
    city varchar(45) not null,
    create_time datetime default current_timestamp,
    primary key(member_id)
);
desc member0705;

insert into member0705(name, password, email, phone, address, city, create_date) values(1,111,'1@1.com',1111,22,default,22,now());

