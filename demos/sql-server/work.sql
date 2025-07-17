CREATE DATABASE ECommerceDB;
USE ECommerceDB;

DROP TABLE product;

CREATE TABLE product (
    productid INT
);

INSERT INTO product VALUES (1);
SELECT * FROM product;
INSERT INTO product VALUES (1);
INSERT INTO product VALUES (1);
INSERT INTO product VALUES (1);
INSERT INTO product VALUES (NULL);
INSERT INTO product VALUES ('null');

DELETE FROM product;

DROP TABLE product1;

CREATE TABLE product1 (
    productid INT IDENTITY(100, 5),
    productName VARCHAR(50)
);

INSERT INTO product1 VALUES (1, 'Laptop');
INSERT INTO product1 (productName) VALUES ('Laptop');

