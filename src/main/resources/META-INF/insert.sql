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
-- drop TABLE if EXISTS oauth_client_details;
-- drop TABLE if EXISTS oauth_client_token;
-- drop TABLE if EXISTS oauth_access_token;
-- drop TABLE if EXISTS oauth_refresh_token;
-- drop TABLE if EXISTS oauth_code;
-- CREATE TABLE oauth_client_details (
--   client_id VARCHAR(256) PRIMARY KEY,
--   resource_ids VARCHAR(256),
--   client_secret VARCHAR(256),
--   scope VARCHAR(256),
--   authorized_grant_types VARCHAR(256),
--   web_server_redirect_uri VARCHAR(256),
--   authorities VARCHAR(256),
--   access_token_validity INTEGER,
--   refresh_token_validity INTEGER,
--   additional_information VARCHAR(4096),
--   autoapprove VARCHAR(256)
-- );
-- CREATE TABLE oauth_client_token (
--   token_id VARCHAR(256),
--   token bytea,
--   authentication_id VARCHAR(256),
--   user_name VARCHAR(256),
--   client_id VARCHAR(256)
-- );
-- CREATE TABLE oauth_access_token (
--   token_id VARCHAR(256),
--   token bytea,
--   authentication_id VARCHAR(256),
--   user_name VARCHAR(256),
--   client_id VARCHAR(256),
--   authentication bytea,
--   refresh_token VARCHAR(256)
-- );
-- CREATE TABLE oauth_refresh_token (
--   token_id VARCHAR(256),
--   token bytea,
--   authentication bytea
-- );
-- CREATE TABLE oauth_code (
--   code VARCHAR(256), authentication bytea
-- );
INSERT INTO saw_user_details (enabled, login, password) VALUES (TRUE, 'nowy', '123');
INSERT INTO saw_user_details (enabled, login, password) VALUES (TRUE, 'nowy2', '1234');
INSERT INTO saw_role (name) VALUES ('USER');
INSERT INTO saw_user_role (userid, role_roleid) VALUES (1, 1);
INSERT INTO saw_user (userdetails_userid, firstName, lastName) VALUES (1, 'kowalczyk', 'kowal');
INSERT INTO saw_user (userdetails_userid, firstname, email) VALUES (2, 'nowy2', '123');
INSERT INTO saw_workout(user_id, date) VALUES (1, '2015-02-02');
INSERT INTO saw_workout(user_id, date) VALUES (1, '2015-03-03');
INSERT INTO saw_exercise (name, exerciseType) VALUES ('Przysiady', 'LEGS');
INSERT INTO saw_exercise (name, exerciseType) VALUES ('Przysiady przednie', 'LEGS');
INSERT INTO saw_exercise (name, exerciseType) VALUES ('Wykroki', 'LEGS');
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (1, 1, 10, 3);
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (2, 1, 10, 3);
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (3, 1, 10, 3);
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (2, 2, 7, 2);
INSERT INTO saw_userExercise (exercise_id, workout_id, repeat, series) VALUES (1, 2, 12, 4);
INSERT INTO saw_userweight (user_id_userid, date, weight_kg) VALUES (1,'2016-10-11', 64);
INSERT INTO saw_userinfo (userid, weight_id) VALUES (1, 1);
INSERT INTO saw_usernotes (userid, date, note)VALUES (1, '2016-10-23', 'notatka pierwsza jakas tam blalblablalbablabl');
INSERT INTO saw_usernotes (userid, date, note)VALUES (1, '2016-09-26', 'njklsadhaslkdjlaksdjlaskdjlaksjdlakdjlskajd');


