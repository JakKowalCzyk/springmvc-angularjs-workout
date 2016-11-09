-- drop table if EXISTS saw_user CASCADE ;
-- drop table if EXISTS saw_userInfo CASCADE ;
-- drop table if EXISTS saw_userWeight CASCADE ;
-- drop table if EXISTS saw_userNotes CASCADE ;
-- drop table if EXISTS saw_exercise CASCADE ;
-- drop table if EXISTS saw_userExercise CASCADE ;
--
-- create table saw_user(user_id SERIAL NOT NULL PRIMARY KEY, login VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255), birthDay DATE , email VARCHAR(255), password VARCHAR(255));
--
-- CREATE TABLE saw_userWeight(uweight_id SERIAL not null PRIMARY KEY,user_id int REFERENCES saw_user(user_id), weight_kg int, date DATE);
--
-- CREATE TABLE saw_exercise(exercise_id SERIAL not null PRIMARY KEY, name VARCHAR(255), description text, exerciseType VARCHAR(255));
--
-- CREATE TABLE saw_workout(workout_id SERIAL NOT NULL PRIMARY KEY ,user_id int REFERENCES saw_user(user_id), date DATE);
--
-- CREATE TABLE saw_userExercise(usexercise_id SERIAL NOT NULL PRIMARY key, exercise_id int REFERENCES saw_exercise(exercise_id), workout_id int REFERENCES saw_workout(workout_id), repeat int, series int);
--
-- create table saw_userInfo(uinfo_id SERIAL NOT NULL PRIMARY KEY, user_id int REFERENCES saw_user(user_id), actual_weight int REFERENCES saw_userWeight(uweight_id), efavourite_id int REFERENCES saw_exercise(exercise_id));
--
-- CREATE TABLE saw_userNotes(unotes_id SERIAL NOT NULL PRIMARY key, user_id int REFERENCES saw_user(user_id), note text, date DATE );

INSERT INTO saw_user (login, firstName, lastName) VALUES ('kuba', 'kowalczyk', 'kowal');
INSERT INTO saw_workout(user_id, date) VALUES (1, '2015-02-02');
INSERT INTO saw_exercise (name, exerciseType) VALUES ('Przysiady', 'LEGS');
INSERT INTO saw_exercise (name, exerciseType) VALUES ('Przysiady przednie', 'LEGS');
INSERT INTO saw_exercise (name, exerciseType) VALUES ('Wykroki', 'LEGS');
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (1, 1, 10, 3);
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (2, 1, 10, 3);
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (3, 1, 10, 3);
INSERT INTO saw_userinfo (user_id) VALUES (1);
INSERT INTO saw_userweight (user_id_user_id, date, weight_kg) VALUES (1,'2016-10-11', 64);


