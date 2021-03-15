create table USERS (sl_no int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),username varchar(20),password varchar(20),phone varchar(15),email_id varchar(50));
select * from users;
insert into users(username,password,phone,email_id) values('admin','admin','8095642067','lionmonkey001@gmail.com');
insert into users(username,password,phone,email_id) values('user','user','9483621844','gowthamhm002@gmail.com');
create table folders(sl_no int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),folder_name varchar(30),creator varchar(30),Date date,Time time);
select * from folders;