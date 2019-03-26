SELECT log.email, log.password, stud.name, stud.phone, maj.name AS major_name, maj.credits, t.name AS teacher_name, t.phone AS teacher_phone
FROM logins AS log
	JOIN students AS stud
		ON stud.login_id = log.id
	JOIN majors AS maj
		ON stud.major_id = maj.id
	JOIN teachers AS t
		ON t.major_id = maj.id