CREATE TABLE superheroes(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	name TEXT,
	power INTEGER,
	gender TEXT
);

CREATE TABLE details(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	age INTEGER,
	country TEXT,
	superhero_id INTEGER,
	FOREIGN KEY(superhero_id) REFERENCES superheroes(id)
);

INSERT INTO superheroes
VALUES (1, 'Superman', 100, 'M');
INSERT INTO superheroes (name, power, gender)
VALUES
	('Spider man', 85, 'M'),
	('Wonder woman', 90, 'F'),
	('Thor', 95, 'M'),
	('Black Panther', 80, 'M'),
	('Batman', 92, 'M'),
	('Cat', 75, 'F'),
	('Invisible Woman', 92, 'F'),
	('Iron man', 97, 'M'),
	('Hulk', 85, 'M'),
	('Aquaman', 75, 'M');

INSERT INTO details
VALUES (1, 45, 'USA');
INSERT INTO details (age, country)
VALUES
	(54, "Mongolia"),
	(23, "Korea"),
	(54, "USA"),
	(80, "Japan"),
	(23, "USA"),
	(20, "Mongolia"),
	(77, "China"),
	(54, "Korea"),
	(44, "USA"),
	(75, "China");