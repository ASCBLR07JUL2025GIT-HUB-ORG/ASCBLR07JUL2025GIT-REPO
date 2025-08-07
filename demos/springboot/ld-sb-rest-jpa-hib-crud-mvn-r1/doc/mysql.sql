-- Active: 1753685887745@@127.0.0.1@3306@sbdb1
CREATE DATABASE SBDB1;
use SBDB1;

DELETE FROM EMPLOYEES;
SELECT * FROM EMPLOYEES;
DROP TABLE IF EXISTS EMPLOYEES;
CREATE TABLE `employees` (
  `id` bigint NOT NULL PRIMARY KEY,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL
);

INSERT INTO `employees` (`id`, `first_name`, `last_name`, `email_address`) VALUES
(1, 'John', 'Doe', 'john.doe@example.com'),
(2, 'Jane', 'Smith', 'jane.smith@example.com'),
(3, 'Mike', 'Johnson', 'mike.johnson@example.com');