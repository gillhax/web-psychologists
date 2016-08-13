CREATE TABLE PROBLEM(
    problem_id INT NOT NULL auto_increment,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (problem_id)
);

CREATE TABLE PSYCHOLOGIST(
    psychologist_id INT NOT NULL auto_increment,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(255) NOT NULL,
    contacts VARCHAR(255) NOT NULL,
    photo VARCHAR(255) NOT NULL,
    about TEXT NOT NULL,
    PRIMARY KEY (psychologist_id),
    UNIQUE (user_name)
};

CREATE TABLE PUBLICATION(
    publication_id INT NOT NULL auto_increment,
    problem_id INT NOT NULL,
    psychologist_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content MEDIUMTEXT NOT NULL,
    PRIMARY KEY (publication_id),
    CONSTRAINT fk_publication_to_problem FOREIGN KEY (problem_id) REFERENCES PROBLEM (problem_id) ON UPDATE CASCADE
    CONSTRAINT fk_publication_to_psychologist FOREIGN KEY (psychologist_id) REFERENCES PSYCHOLOGIST (psychologist_id) ON UPDATE CASCADE
);


create table USER_DOCUMENT(
    id INT NOT NULL AUTO_INCREMENT,
    psychologist_id INT NOT NULL,
    name  VARCHAR(200) NOT NULL,
    type VARCHAR(100) NOT NULL,
    content longblob NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_document_to_user FOREIGN KEY (psychologist_id) REFERENCES PSYCHOLOGIST (psychologist_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE persistent_logins (
    username VARCHAR(255) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);