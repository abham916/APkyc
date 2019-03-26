SELECT log.email, log.password, stud.name, stud.phone, maj.name AS major_name, maj.credits
FROM logins AS log
	JOIN students AS stud
		ON stud.login_id = log.id
	JOIN majors AS maj
		ON stud.major_id = maj.id