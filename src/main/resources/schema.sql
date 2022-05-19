create sequence category_id_seq START WITH 1 INCREMENT BY 1;

create table CategoryJPA (
	CategoryId number(10,0) primary key,
	CategoryName varchar2(50) not null,
	Description varchar2(100) not null
);

create sequence ProductJPA_productId_seq START WITH 1 INCREMENT BY 1;

create table ProductJPA (
	ProductId number(10,2) primary key,
	ProductName varchar2(50) not null,
	category number(10,0) not null,
	Manufacturer varchar2(50),
	Price double precision not null,
	foreign key (category) references CategoryJPA(categoryid)
);






   
