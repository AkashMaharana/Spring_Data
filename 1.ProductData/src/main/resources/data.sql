drop table product if exists;

create table product(
	id INT PRIMARY KEY,
	name VARCHAR2(50) NOT NULL,
	description VARCHAR2(50) NOT NULL,
	price int NOT NULL
);

insert into product values (1,'Earphone', 'JBL Wireless Earphone',456);