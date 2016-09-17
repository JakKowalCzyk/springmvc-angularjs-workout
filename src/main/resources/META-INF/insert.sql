drop table if EXISTS saw_user CASCADE ;

create table saw_user(id int NOT NULL PRIMARY KEY, login VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255), birthDay DATE , email VARCHAR(255), password VARCHAR(255));
