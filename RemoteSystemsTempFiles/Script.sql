--<ScriptOptions statementTerminator=";"/>

CREATE TABLE questionnaire (
	id INT NOT NULL,
	u_id INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	instruction VARCHAR(1024),
	set date DATETIME NOT NULL,
	end date DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE one_question (
	id INT NOT NULL,
	q_id INT NOT NULL,
	title_num INT NOT NULL,
	stem VARCHAR(1024) NOT NULL,
	type INT DEFAULT 0,
	nessecity INT DEFAULT 1,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE users (
	id INT NOT NULL,
	username VARCHAR(20),
	password VARCHAR(20),
	name VARCHAR(20),
	mail VARCHAR(45),
	qq VARCHAR(12),
	phone VARCHAR(11),
	role INT DEFAULT 0,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE answers (
	u_id INT NOT NULL,
	o_id INT NOT NULL,
	answer VARCHAR(1024) NOT NULL,
	PRIMARY KEY (u_id,o_id)
) ENGINE=InnoDB;

CREATE TABLE q_options (
	q_id INT NOT NULL,
	title VARCHAR(1) NOT NULL,
	property VARCHAR(1024),
	PRIMARY KEY (q_id,title)
) ENGINE=InnoDB;

CREATE TABLE answer_questionnaire (
	u_id INT NOT NULL,
	q_id INT NOT NULL,
	submit_time DATETIME,
	if_complete INT DEFAULT 0,
	PRIMARY KEY (u_id,q_id)
) ENGINE=InnoDB;

CREATE INDEX q_id ON answer_questionnaire (q_id ASC);

CREATE INDEX o_id ON answers (o_id ASC);

CREATE INDEX q_id ON one_question (q_id ASC);

CREATE INDEX u_id ON questionnaire (u_id ASC);

ALTER TABLE answer_questionnaire ADD PRIMARY KEY (u_id, q_id);

ALTER TABLE answer_questionnaire ADD CONSTRAINT answer_questionnaire_ibfk_1 FOREIGN KEY (q_id)
	REFERENCES questionnaire (id);

ALTER TABLE answer_questionnaire ADD CONSTRAINT answer_questionnaire_ibfk_2 FOREIGN KEY (u_id)
	REFERENCES users (id);

