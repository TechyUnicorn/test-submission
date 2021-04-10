DROP TABLE IF EXISTS Quiz;

CREATE TABLE Quiz (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL
);

--
--INSERT INTO billionaires (first_name, last_name, career) VALUES
--  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
--  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
--  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
--

DROP TABLE IF EXISTS QuizQuestions;

CREATE TABLE QuizQuestions (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  options VARCHAR(250) NOT NULL,
  correct_option VARCHAR(250) NOT NULL
  quiz VARCHAR(250) NOT NULL
  points VARCHAR(250) NOT NULL
);