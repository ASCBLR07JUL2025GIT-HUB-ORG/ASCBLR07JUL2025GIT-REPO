DROP DATABASE TestDB;

CREATE DATABASE TestDB;

USE TestDB;

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    email VARCHAR(100),
    last_name VARCHAR(100)
);


INSERT INTO Users (user_id, email, last_name)
VALUES
(4, 'john.pleasego@example.com', 'Go');

INSERT INTO Users (user_id, email, last_name)
VALUES
(1, 'john.doe@example.com', 'Doe'),
(2, 'jane.smith@example.com', 'Smith'),
(3, 'sam.wilson@example.com', 'Wilson');

Select * from users;