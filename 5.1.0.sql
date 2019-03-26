CREATE TABLE logins(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	email TEXT NOT NULL,
	password TEXT NOT NULL
);

CREATE TABLE majors(
	id INTEGER PRIMARY KEY NOT NULL,
	name TEXT,
	credits INTEGER
);

CREATE TABLE students(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	login_id INTEGER NOT NULL,
	major_id INTEGER NOT NULL,
	name TEXT,
	phone INTEGER,
	FOREIGN KEY(login_id) REFERENCES logins(id),
	FOREIGN KEY(major_id) REFERENCES majors(id)
);

CREATE TABLE teachers(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	major_id INTEGER NOT NULL,
	name TEXT,
	phone INTEGER,
	FOREIGN KEY(major_id) REFERENCES majors(id)
);


INSERT INTO logins
VALUES (1, 'john@gmail.com', 'abc123');

INSERT INTO majors
VALUES (1, 'CS', 120);

INSERT INTO students
VALUES (1, 1, 1, 'John Park', 99991234);

INSERT INTO teachers
VALUES 
	(1, 1, 'James Bond', 88881234),
	(2, 1, 'Moon Bae', 98761234),
	(3, 1, 'J Lee', 87661234);
	