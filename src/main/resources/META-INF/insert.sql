drop table if EXISTS saw_user CASCADE ;
drop table if EXISTS saw_userInfo CASCADE ;
drop table if EXISTS saw_userWeight CASCADE ;
drop table if EXISTS saw_userNotes CASCADE ;
drop table if EXISTS saw_exercise CASCADE ;
drop table if EXISTS saw_userExercise CASCADE ;
drop table if EXISTS saw_favouriteExercise CASCADE ;

create table saw_user(user_id int NOT NULL PRIMARY KEY, login VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255), birthDay DATE , email VARCHAR(255), password VARCHAR(255));

CREATE TABLE saw_userWeight(uweight_id int not null PRIMARY KEY, user_id int REFERENCES saw_user(user_id), weight_kg int, date DATE);

CREATE TABLE saw_exercise(exercise_id int not null PRIMARY KEY, name VARCHAR(255), description text, exerciseType VARCHAR(255));

CREATE TABLE saw_userExercise(usexercise_id int NOT NULL PRIMARY key, exercise_id int REFERENCES saw_exercise(exercise_id), user_id int REFERENCES saw_user(user_id), repeat int, series int, date DATE );

CREATE TABLE saw_workout(workout_id int NOT NULL PRIMARY KEY ,user_id int REFERENCES saw_user(user_id), date DATE, exercise_id int REFERENCES saw_userExercise(usexercise_id));

CREATE table saw_favouriteExercise(efavourite_id int NOT NULL PRIMARY KEY, exercise_id int REFERENCES saw_userExercise(usexercise_id));

create table saw_userInfo(uinfo_id int NOT NULL PRIMARY KEY, user_id int REFERENCES saw_user(user_id), actual_weight int REFERENCES saw_userWeight(uweight_id), efavourite_id int REFERENCES saw_favouriteExercise(efavourite_id));

CREATE TABLE saw_userNotes(unotes_id int NOT NULL PRIMARY key, user_id int REFERENCES saw_user(user_id), note text, date DATE );




