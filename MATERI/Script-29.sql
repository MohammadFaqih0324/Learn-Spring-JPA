show databases;

create database learn_jpa;

use learn_jpa;

show tables;

desc address ;

drop table user_roles;
drop table `user`;
drop table `role`;
drop table address;
drop table address ;
drop table major;




-- DDL CREATE TABLE --

-- create table `major` 
create table major(
id bigint not null primary key,
name varchar(255),
is_actived boolean,
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255)
);

-- create table `address` 
create table address(
id bigint not null primary key,
address varchar(255),
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255)
);

-- create table `student` 
create table student(
id bigint not null,
name varchar(255),
age int,
major bigint,
address bigint,
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255),
primary key (id),
constraint FK_ProgramStudent foreign key (major) references Major(id),
constraint FK_AddressStudent foreign key (address) references Address(id)
);

-- create table `lesson` 
create table lesson(
id bigint not null primary key,
name varchar(255),
is_actived boolean,
major bigint,
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255),
constraint FK_MajorLesson foreign key (major) references Major(id)
);

-- create table `user` 
create table `user`(
id bigint not null primary key,
username varchar(255),
`password` varchar(255),
is_actived boolean,
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255)
);

-- create table `role` 
create table `role`(
id bigint not null primary key,
name varchar(255),
is_actived boolean,
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255)
);

-- create table `user_roles` 
create table user_roles(
id bigint not null primary key,
`user` bigint,
`role` bigint,
created_date date,
created_by varchar(255),
updated_date date,
updated_by varchar(255),
constraint FK_User foreign key (`user`) references `user`(id),
constraint FK_Role foreign key (`role`) references `role`(id)
);




-- DML INSERT --

-- insert into table `major` 
INSERT INTO major (id, name, is_actived, created_date, created_by, updated_date, updated_by)
VALUES 
       (1, 'Backend Developer', true, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (2, 'Frontend Developer', true, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (3, 'Fullstack Developer', true, '2022-01-01', 'Admin', '2022-01-01', 'Admin');


-- insert into tabel `address`
INSERT INTO address (id, address, created_date, created_by, updated_date, updated_by)
VALUES 
  (1, 'Karawang', '2022-03-13', 'Admin', '2022-03-13', 'Admin'),
  (2, 'Jakarta', '2022-03-13', 'Admin', '2022-03-13', 'Admin'),
  (3, 'Bandung', '2022-03-13', 'Admin', '2022-03-13', 'Admin'),
  (4, 'Tual', '2022-03-13', 'Admin', '2022-03-13', 'Admin');
 
 
-- insert into table `student`       
INSERT INTO student (id, name, age, major, address, created_date, created_by, updated_date, updated_by)
VALUES 
 (1, 'Vivi', 20, 1, 1, '2022-01-01', 'Systems', '2022-01-01', 'Systems'),
 (2, 'Faqih', 20, 2, 2, '2022-01-01', 'Systems', '2022-01-01', 'Systems'),
 (3, 'Jafar', 20, 3, 3, '2022-01-01', 'Systems', '2022-01-01', 'Systems'),
 (4, 'Nabhan', 20, 3, 4, '2022-01-01', 'Systems', '2022-01-01', 'Systems');      


-- insert into table `lesson` 
INSERT INTO lesson (id, name, is_actived, major, created_date, created_by, updated_date, updated_by)
VALUES 
       (1, 'Introduction to Programming', true, 1, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (2, 'Basic Java', true, 1, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (3, 'Java Build Automation : Maven', true, 1, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (4, 'Framework : Spring and JPA', true, 1, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (5, 'Framework : Springboot and Spring Security', true, 1, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (6, 'Basic : Html, Css and Javascript', true, 2, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (7, 'Framework : ReactJS', true, 2, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (8, 'Final Project', true, 2, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (9, 'Introduction to Programming', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (10, 'Basic Java', true, 1, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (11, 'Java Build Automation : Maven', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (12, 'Framework : Spring and JPA', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (13, 'Framework : Springboot and Spring Security', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (14, 'Basic : Html, Css and Javascript', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (15, 'Framework : ReactJS', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),
       (16, 'Final Project', true, 3, '2022-01-01', 'Admin', '2022-01-01', 'Admin'),

-- insert into table `user` 
INSERT INTO `user` (id, username, `password`, is_actived, created_date, created_by, updated_date, updated_by)
VALUES 
(1, 'john_doe', 'password123', true, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(2, 'jane_smith', 'password456', true, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(3, 'bob_johnson', 'password789', true, '2022-01-01', 'admin', '2022-01-01', 'admin');


-- insert into table `role` 
INSERT INTO `role` (id, name, is_actived, created_date, created_by, updated_date, updated_by)
VALUES 
(1, 'ADMIN', true, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(2, 'USER', true, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(3, 'GUEST', true, '2022-01-01', 'admin', '2022-01-01', 'admin');

-- insert into table `user_roles` 
INSERT INTO `user_roles` (id, `user`, `role`, created_date, created_by, updated_date, updated_by)
VALUES 
(1, 1, 1, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(2, 1, 2, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(3, 2, 2, '2022-01-01', 'admin', '2022-01-01', 'admin'),
(4, 3, 3, '2022-01-01', 'admin', '2022-01-01', 'admin');


--  DML SELECT JOIN -- 

select * from learn_jpa.student;
select * from learn_jpa.address;
select * from learn_jpa.major;

select s.name as 'student' , m.name as 'major', a.address from student s 
JOIN major m ON s.major = m.id
JOIN address a ON s.address = a.id;



