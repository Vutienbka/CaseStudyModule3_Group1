CREATE DATABASE CaseStudy;
USE CaseStudy;
DROP database CaseStudy;
/*-----------------------------------------------*/
CREATE TABLE Place(
bookPlaceId int primary key not null auto_increment,
placeName nvarchar(50)
);
drop table Place;
/*-----------------------------------------------*/
CREATE TABLE BookType(
bookTypeId int primary key not null auto_increment, 
typeOfBook nvarchar(50)
);
drop table BookType;
/*-----------------------------------------------*/
CREATE table BookTitle(
bookTitleId int primary key not null auto_increment,
bookTypeId int not null,
bookName nvarchar(50) not null,
author nvarchar(50) not null,
quantity Int not null,
price Int,
language nvarchar(30),
description nvarchar(255),
constraint FK_BookTitle_BookType foreign key(bookTypeId) references BookType(bookTypeId)
);
drop table Title;
/*-----------------------------------------------*/
CREATE TABLE Book(
bookId int primary key not null auto_increment,
bookTypeId int not null, 
bookTitleId int not null,
bookPlaceId int not null,
quantity Int not null,
status boolean not null,
situation nvarchar(20),
constraint FK_Book_BookTitle foreign key(bookTitleId) references BookTitle(bookTitleId),
constraint FK_Book_BookType foreign key(bookTypeId) references BookType(bookTypeId),
constraint FK_Book_Place foreign key(bookPlaceId) references Place(bookPlaceId)
);
drop table Book;
/*-----------------------------------------------*/
CREATE TABLE Reader(
readerId int primary key not null auto_increment,
readerName nvarchar(70) not null,
identificationId nvarchar(20),
dateOfBirth date,
address nvarchar(150),
occupation  nvarchar(50),
email nvarchar(70),
unique (identificationId)
);
drop table Reader;
/*-----------------------------------------------*/
CREATE TABLE registerDetail(
registerId int primary key not null auto_increment,
readerId int not null,
bookTypeId int not null,
bookTitleId int not null,
bookId int not null,
loanDate date,
loanSituation nvarchar(20),
receiveDate date,
receiveSituation nvarchar(20),
quantity int,
unique(bookTypeId,bookTitleId,bookId),
constraint FK_registerDetail_reader foreign key(readerId) references Reader(readerId),
constraint FK_registerDetail_book foreign key(bookId) references Book(bookId),
constraint FK_registerDetail_bookTitle foreign key(bookTitleId) references BookTitle(bookTitleId),
constraint FK_registerDetail_booktype foreign key(bookTypeId) references BookType(bookTypeId),
unique(bookId)
);
drop table registerDetail;
/*-----------------------------------------------*/

/*Bang Place*/
insert into Place (placeName) values
("PL01"),
("PL02"),
("PL03"),
("PL04"),
("PL05");

/*Tao du lieu bang bookType*/
insert into BookType (typeOfBook) values
("Techology"),
("Finance"),
("History");

/*Tao du lieu bang bookTitle*/
insert into BookTitle ( bookTypeId, bookname, author, quantity, price, language, description) values
(1,"Python","Vu Hoang Nam", 2, 10000,"English", " very good book"),
(1,"Java","Hoang Dai", 2, 20000,"English", " bad book"),
(1,"PHP","Hoang Trung", 2, 30000,"English", " good book"),
(1,"Rubi","Thanh Hoang", 2, 40000,"English", " quite good book"),
(1,"Bootstrap","Hoang Son", 2, 50000,"English", " good book"),

(2,"Marketing","Thanh Sang", 1, 60000,"Vietnamese", " pretty good book"),
(2,"To be rich","Hoang Cam", 1, 70000,"English", " good book"),
(2,"Critical thinking","Thanh Tu", 1, 80000,"English", " so good book"),
(2,"Adminitrtion skill","Quang Khai", 1, 90000,"English", " quote good book"),

(3,"world History","Song Uyen", 1, 120000,"English", " so good book"),
(3,"French History","Thanh Son", 1, 150000,"French", " very good book"),
(3,"Vietnam History","Pham Vui", 1, 200000,"Vietnamese", " good book"),
(3,"Germany History","Vu Quyen", 1, 300000,"Germany", " good book"),
(3,"American History","Dinh Thanh Nam", 1, 350000,"English", " good book");

/*Tao du lieu bang book*/
insert into Book( bookTypeId, bookTitleID, bookPlaceId, quantity, status, situation) values
(1,1,1,1,false,"new"),
(1,2,1,1,false,"new"),
(1,3,2,1,false,"new"),
(1,4,2,1,false,"new"),
(1,5,3,1,false,"new"),
(1,1,1,1,false,"new"),
(1,2,1,1,false,"new"),
(1,3,2,1,false,"new"),
(1,4,2,1,false,"new"),
(1,5,3,1,false,"new"),

(2,6,4,1,false,"new"),
(2,7,1,1,false,"new"),
(2,8,2,1,false,"new"),
(2,9,4,1,false,"new"),

(3,10,3,1,false,"new"),
(3,11,3,1,false,"new"),
(3,12,5,1,false,"new"),
(3,13,5,1,false,"new"),
(3,14,5,1,false,"new");

/*Tao du lieu bang Reader*/
insert into Reader ( readerName, identificationId, dateOfBirth, address, occupation, email) values
("Le Hoang", "HV01",'2010-10-12',"Ha Noi","Engineer","lehoanghanoi@gmail.com"),
("Vu Phong", "HV02",'2010-9-12',"Ha Noi","Engineer","vuphong@gmail.com"),
("Dinh Trong", "HV03",'2010-8-12',"Ha Noi","Engineer","dinhtrong@gmail.com"),
("Phuoc Quy", "HV04",'2010-7-12',"Ha Noi","Engineer","phuocquy@gmail.com"),
("Thanh Son", "HV05",'2010-6-12',"Ha Noi","Engineer","thanhson@gmail.com");

/*Tao du lieu bang registerDetail*/
insert into registerDetail ( readerId, bookTypeId, bookTitleId, bookId, loanDate, loanSituation, receiveDate, receiveSituation, quantity) values
(1, 1, 1, 1,'2020-12-20',"new",'2020-12-22','', 1),
(1, 1, 1, 2,'2020-11-20',"new",'2020-11-25','', 1),
(1, 1, 2, 3,'2020-10-20',"new",'2020-11-28','', 1);
SELECT registerId FROM registerDetail;
create view dataTable as
SELECT DISTINCT registerDetail.bookId, registerDetail.loanDate, registerDetail.loanSituation, registerDetail.receiveSituation,
 BookType.typeOfBook, BookTitle.bookName FROM 
BookType INNER JOIN registerDetail ON registerDetail.bookTypeId = BookType.bookTypeId
                       INNER JOIN BookTitle ON registerDetail.bookTitleId = BookTitle.bookTitleId;
 Drop view dataTable; 
 SELECT * FROM dataTable where bookId = 1;
 
 /* Xem tong quan*/
 create view bookOverview as
 SELECT  DISTINCT BookType.bookTypeId, BookTitle.bookTitleId, BookTitle.bookName, BookType.typeOfBook, BookTitle.author, BookTitle.quantity, 
 BookTitle.price, BookTitle.language, Book.status, Book.situation
 FROM BookType INNER JOIN Book ON BookType.bookTypeId = Book.bookTypeId
                         INNER JOIN BookTitle ON   BookTitle.bookTitleId = Book.bookTitleId; 
 SELECT * FROM bookOverview;
 Drop view bookOverView; 
 
 /*Xem chi tiet*/
 create table bookDetailView as
 SELECT  DISTINCT Book.bookId, BookTitle.bookTitleId, BookType.bookTypeId, BookTitle.bookName, BookType.typeOfBook, BookTitle.author, Book.quantity, 
 BookTitle.price, BookTitle.language, Book.status, Book.situation
 FROM BookType INNER JOIN Book ON BookType.bookTypeId = Book.bookTypeId
                         INNER JOIN BookTitle ON   BookTitle.bookTitleId = Book.bookTitleId;
							
 SELECT * FROM bookDetailView;
 Drop table bookDetailView; 
 