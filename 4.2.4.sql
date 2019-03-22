SELECT sh.name, sh.power, sh.gender, d.age, d.country
FROM superheroes AS sh
JOIN details AS d
ON sh.id = d.superhero_id
WHERE country = 'USA'