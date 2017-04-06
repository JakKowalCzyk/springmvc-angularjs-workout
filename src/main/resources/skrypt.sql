--INSERT
INSERT INTO user_details (enabled, login, hashed_Password, birth_day, email, first_name, last_name)
VALUES (TRUE, 'nowy', '123', '1990-01-22', 'kowal@email.pl', 'kowalczyk', 'kowal');
INSERT INTO user_details (enabled, login, hashed_Password, birth_day, email, first_name, last_name)
VALUES (TRUE, 'nowy2', '1234', '1996-01-22', 'email@email.pl', 'nowy2', 'nowy');
INSERT INTO user_details (enabled, login, hashed_Password) VALUES (TRUE, 'nowy3', '1234');
INSERT INTO role (role_type) VALUES ('USER');
INSERT INTO user_details_roles (user_details_id, roles_id) VALUES (1, 1);
INSERT INTO user_details_roles (user_details_id, roles_id) VALUES (2, 1);
--workout
INSERT INTO workout (user_details_id, date) VALUES (1, '2015-02-02');
INSERT INTO workout (user_details_id, date) VALUES (1, '2015-03-03');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-06-20');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-06-21');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-06-23');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-06-25');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-06-28');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-06-30');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-07-02');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-07-05');
INSERT INTO workout (user_details_id, date) VALUES (1, '2016-07-10');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-03');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-05');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-07');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-08');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-09');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-12');
INSERT INTO workout (user_details_id, date) VALUES (2, '2016-03-14');
--exercise
INSERT INTO exercise (name, description, exercise_type) VALUES ('Przysiady', 'Przysiady klasyczne głebokie', 'LEGS');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Przysiady przednie', 'przysiady przednie ze sztangą z przodu', 'LEGS');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wykroki z hantlami', 'wykorki w miejscu lub chodzone', 'LEGS');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wyciskanie sztangi', 'wyciskanie na ławce plaskiej', 'CHEST');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('wyciskanie skośne', 'wyciskanie sztangi na ławce skośnej', 'CHEST');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wyciskanie ze sztangielkami', 'Wyciskanie na ławce płaskiej ze sztangielkami', 'CHEST');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wyciskanie skośne ze sztangielkami', 'Wyciskanie na ławce skośnej ze sztangielkami', 'CHEST');
INSERT INTO exercise (name, description, exercise_type) VALUES ('Martwy ciąg', 'Martwy ciąg ze sztangą', 'BACK');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Martwy ciąg na prostych nowgach', 'Martwy ciąg ze sztangą na prostych nogach', 'BACK');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Martwy ciąg sztangielki', 'Martwy ciąg ze sztangielkami', 'BACK');
INSERT INTO exercise (name, description, exercise_type) VALUES ('Wiosłowanie', 'Wiosłowanie ze sztangą', 'BACK');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wiosłowanie ze sztangielkami', 'Wiosłowanie ze sztangielkami w oparciu', 'BACK');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wyciskanie żołnierskie', 'Wyciskanie żołnierskie ze sztangą', 'SHOULDERS');
INSERT INTO exercise (name, description, exercise_type)
VALUES ('Wyciskanie żołnierskie hantle', 'Wyciskanie żołnierskie z hantlami', 'SHOULDERS');
INSERT INTO exercise (name, description, exercise_type) VALUES ('Hantle biceps', 'wyciskanie na biceps', 'HANDS');
INSERT INTO exercise (name, description, exercise_type) VALUES ('Pompki na poręczy', 'pompki na triceps', 'HANDS');
--workout 1
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 1, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (7, 1, 7, 6);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (8, 1, 9, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (9, 1, 11, 2);
--workout 2
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 2, 13, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 2, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (5, 2, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 2, 8, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 2, 12, 5);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (16, 2, 11, 3);
--workout 3
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 3, 11, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 3, 7, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 3, 8, 5);
--workout 4
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 4, 10, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 4, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 4, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (4, 4, 11, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (5, 4, 10, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (6, 4, 9, 3);
--workout 5
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (7, 5, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (8, 5, 11, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (9, 5, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 5, 8, 3);
--workout 6
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (13, 6, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (14, 6, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (15, 6, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (16, 6, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 6, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 6, 11, 3);
--workout 7
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 7, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 7, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 7, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (13, 7, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 7, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 7, 10, 4);
--workout 8
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 8, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 8, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (7, 8, 7, 6);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (8, 8, 9, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (9, 8, 11, 2);
--workout 9
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 9, 13, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 9, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (5, 9, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 9, 8, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 9, 12, 5);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (16, 9, 11, 3);
--workout 10
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 10, 11, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 10, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 10, 7, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 10, 9, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (14, 10, 10, 1);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 10, 8, 5);
--workout 11
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 11, 10, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 11, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 11, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (6, 11, 9, 3);
--workout 12
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (7, 12, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (8, 12, 11, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (9, 12, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 12, 8, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 12, 11, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 12, 12, 1);
--workout 13
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (13, 13, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (14, 13, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (15, 13, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 13, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 13, 11, 3);
--workout 14
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 14, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 14, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 14, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (13, 14, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 14, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 14, 10, 4);
--workout 15
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (13, 15, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (14, 15, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (15, 15, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (16, 15, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 15, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 15, 11, 3);
--workout 16
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 16, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 16, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 16, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (13, 16, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 16, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 16, 10, 4);
--workout 17
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (11, 17, 11, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (12, 17, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 17, 7, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 17, 9, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (14, 17, 10, 1);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 17, 8, 5);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (5, 17, 9, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (7, 17, 10, 3);
--workout 18
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (1, 18, 10, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (2, 18, 10, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (3, 18, 12, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (4, 18, 11, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (5, 18, 10, 2);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (7, 18, 10, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (8, 18, 11, 4);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (9, 18, 9, 3);
INSERT INTO user_exercise (exercise_id, workout_id, repeat, series) VALUES (10, 18, 8, 3);

--weight
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2015-02-02', 50);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2015-03-03', 51);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-06-20', 52);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-06-21', 53);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-06-23', 54);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-06-25', 52);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-06-28', 52);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-06-30', 53);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-07-02', 52);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-07-05', 57);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (1, '2016-07-10', 58);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-03', 70);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-05', 72);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-07', 71);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-08', 69);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-09', 70);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-12', 70);
INSERT INTO user_weight (user_details_id, date, weight_kg) VALUES (2, '2016-03-14', 71);

INSERT INTO user_info (user_details_id, exercise_id, weight_id) VALUES (1, 11, 11);
INSERT INTO user_info (user_details_id, exercise_id, weight_id) VALUES (2, 4, 18);

INSERT INTO user_notes (user_details_id, date, note)
VALUES (1, '2016-10-23', 'notatka pierwsza jakas tam blalblablalbablabl');
INSERT INTO user_notes (user_details_id, date, note)
VALUES (1, '2016-09-26', 'njklsadhaslkdjlaksdjlaskdjlaksjdlakdjlskajd');
