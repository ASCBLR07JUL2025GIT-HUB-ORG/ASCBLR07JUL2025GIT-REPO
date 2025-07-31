-- Active: 1753685887745@@127.0.0.1@3306@ladb
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


delete from users where user_id > 5;
Select * from users;
Select * from users order by user_id desc;
Select * from users where user_id between 2000 and 2099;
Select * from users where user_id >= 2000 and user_id <= 2099;
Select * from users where user_id not between 2000 and 2099;

Select * from users
order by user_id desc;

CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10, 2)
);

INSERT INTO Products (product_id, product_name, price)
VALUES
(1, 'Laptop', 999.99),
(2, 'Smartphone', 699.50),
(3, 'Tablet', 399.00),
(4, 'Wireless Mouse', 25.75);
SELECT * FROM Products;


SELECT * FROM Users where user_id=1 or user_id=2;
SELECT * FROM Users where user_id=1 and user_id=2;
SELECT * FROM Users where user_id=1 and user_id=2 or user_id=1 and user_id=2;

SELECT @@VERSION

USE AdventureWorksLT2022;
SELECT * FROM SalesLT.ADDRESS;


-- Generate Database name ladb
CREATE DATABASE ladb;

-- Use Database ladb
USE ladb;

-- Generate MySQL table
CREATE TABLE product (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    quantity INT
);

-- Insert a record into MySQL table
INSERT INTO product (id, name, price, quantity) VALUES ('1', 'Laptop', 999.99, 1);


-- Select all records from MySQL table
SELECT * FROM product ;





-- Generate Database name ladb
CREATE DATABASE ladb;

-- Use Database ladb
USE ladb;

-- Generate MySQL table
CREATE TABLE product (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    quantity INT
);

-- Insert a record into MySQL table
INSERT INTO product (id, name, price, quantity) VALUES ('1', 'Laptop', 999.99, 1);
Insert into product (id, name, price, quantity) VALUES ('2', 'Smartphone', 699.50, 2);  
Insert into product (id, name, price, quantity) VALUES ('3', 'Tablet', 399.00, 3);
Insert into product (id, name, price, quantity) VALUES ('4', 'Wireless Mouse', 25.75, 4);

-- Select all records from MySQL table
SELECT * FROM product ;