create database studentmanagementsystem;

show databases;
use studentmanagementsystem;
create table login(username varchar(25),password varchar(25));
insert into login values('admin','12345');
select * from login;
use studentmanagementsystem;
create table student(name varchar(40),fname varchar(40),Rollno varchar(20),DOB varchar(20),Address varchar(40),Phone varchar(15),Email varchar(20),Course varchar(20));
select * from student;
use studentmanagementsystem;
select * from student;
create table fee1(Course varchar(20), semester1 varchar(20),semester2 varchar(20),semester3 varchar(20),semester4 varchar(20),semester5 varchar(20),semester6 varchar(20),semester7 varchar(20),semester8 varchar(20));
insert into fee1 values("BESE-28","90000","90000","80000","80000","70000","70000","65000","100000");
insert into fee1 values("BESE-27","","","80000","80000","70000","70000","65000","100000");
insert into fee1 values("BESE-26","","","","","70000","70000","65000","100000");
insert into fee1 values("BEIS-3","90000","90000","80000","80000","70000","70000","65000","100000");
insert into fee1 values("BEIS-2","","","80000","80000","70000","70000","65000","100000");
insert into fee1 values("BEIS-1","","","","","70000","70000","65000","100000");
