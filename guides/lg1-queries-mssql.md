### :rocket: SQL Server CRUD & Query Demo

---

#### :bulb: Objectives
- **Create a database and table**
- **Insert, update, delete, and select records**
- **Run advanced queries (joins, aggregations, subqueries, window functions)**
- **Add indexes and soft delete pattern**
- **Bonus: Related tables**

---

### :dart: 1. Create the Database

```sql
CREATE DATABASE ECommerceDB;
GO

USE ECommerceDB;
GO
```

---

### :triangular_ruler: 2. Create the Product Table

```sql

-- CREATE TABLE is used to define a new table in the database.
CREATE TABLE Product (
    -- ProductID is the primary key for the Product table, uniquely identifying each product.
    -- It is an auto-incrementing integer, meaning it will automatically generate a new value
    -- for each new product added to the table.
    -- The IDENTITY(1,1) means it starts at 1 and increments by 1 for each new record.
    -- This is useful for uniquely identifying products without needing to manually assign IDs.
    -- The Product ID is the column name, and it is defined as INT (integer) type.
    -- NVARCHAR vs VARCHAR: NVARCHAR is used for Unicode characters, allowing for a wider range of characters (e.g., international characters).
    ProductID INT IDENTITY(1,1) PRIMARY KEY,
    ProductName NVARCHAR(100) NOT NULL,
    Category NVARCHAR(50),
    Price DECIMAL(10, 2) CHECK (Price >= 0),
    QuantityInStock INT DEFAULT 0 CHECK (QuantityInStock >= 0),
    IsActive BIT DEFAULT 1,
    CreatedAt DATETIME DEFAULT GETDATE(),
    UpdatedAt DATETIME NULL,
    Description NVARCHAR(MAX),
    -- SKU (Stock Keeping Unit) for unique identification. The purpose is to track inventory and sales. 
    -- It is a unique code assigned to each product and helps in managing stock levels, sales, and product information. 
    -- The difference between SKU and ProductID is that SKU is often used for inventory management and sales tracking, while ProductID is a primary key in the database.
    -- Some example values for SKU could be:
    -- MSE0001USB for a wireless mouse, LPT1234GTX for a gaming laptop,
    -- CHR0987BLK for an office chair, DSK5678SIT
    SKU CHAR(10) UNIQUE,
    Rating FLOAT CHECK (Rating BETWEEN 0 AND 5)
);
```

---

### :white_check_mark: 3. Insert Sample Records

```sql
INSERT INTO Product (ProductName, Category, Price, QuantityInStock, SKU, Rating, Description)
VALUES 
('Wireless Mouse', 'Electronics', 25.99, 100, 'MSE0001USB', 4.5, 'Ergonomic wireless mouse'),
('Gaming Laptop', 'Electronics', 1299.99, 50, 'LPT1234GTX', 4.8, 'High performance gaming laptop'),
('Office Chair', 'Furniture', 149.00, 80, 'CHR0987BLK', 4.2, 'Comfortable office chair with lumbar support'),
('Standing Desk', 'Furniture', 299.99, 40, 'DSK5678SIT', 4.7, 'Adjustable standing desk'),
('Bluetooth Speaker', 'Electronics', 45.50, 150, 'SPK2450BT', 4.3, 'Portable Bluetooth speaker');
```

---

### :brain: 4. Read (SELECT Queries)

- **Basic Select**

```sql
SELECT * FROM Product;
```

- **Specific Columns**

```sql
SELECT ProductName, Price, Category FROM Product;
```

- **Filtering**

```sql
SELECT * FROM Product WHERE Category = 'Electronics';
```

- **Sorting**

```sql
SELECT * FROM Product ORDER BY Price DESC;
```

- **Pattern Matching**

```sql
SELECT * FROM Product WHERE ProductName LIKE '%Desk%';
```

---

### :gear: 5. Update Operation

- **Update Stock & Price**

```sql
UPDATE Product
SET QuantityInStock = QuantityInStock - 5,
    Price = Price * 0.95,
    UpdatedAt = GETDATE()
WHERE SKU = 'LPT1234GTX';
```

---

### :warning: 6. Delete Operation

- **Delete a specific product**

```sql
DELETE FROM Product WHERE SKU = 'CHR0987BLK';
```

---

### :test_tube: 7. Additional Queries

- **Aggregation (Total Inventory Value)**

```sql
SELECT 
    SUM(Price * QuantityInStock) AS TotalInventoryValue
FROM Product;
```

- **Group By Category**

```sql
SELECT 
    Category, 
    COUNT(*) AS ProductCount,
    AVG(Price) AS AveragePrice
FROM Product
GROUP BY Category;
```

- **Products with Price above Category Average (Correlated Subquery)**

```sql
SELECT * 
FROM Product P
WHERE Price > (
    SELECT AVG(Price) 
    FROM Product 
    WHERE Category = P.Category
);
```

- **Top 3 Most Expensive Products**

```sql
SELECT TOP 3 * 
FROM Product
ORDER BY Price DESC;
```

- **Window Function: Rank by Price within Category**

```sql
SELECT 
    ProductName, Category, Price,
    RANK() OVER (PARTITION BY Category ORDER BY Price DESC) AS PriceRank
FROM Product;
```

---

### :shield: 8. Add Index for Performance

```sql
CREATE NONCLUSTERED INDEX IX_Product_Category ON Product (Category);
```

---

### :gear: 9. Soft Delete Pattern (Deactivate Product)

```sql
UPDATE Product
SET IsActive = 0, UpdatedAt = GETDATE()
WHERE ProductID = 3; -- Office Chair
```

---

### :white_check_mark: 10. Select Only Active Products

```sql
SELECT * FROM Product WHERE IsActive = 1;
```

---

### :brain: Bonus: Create Related Tables (Optional Extension)

- **Create ProductReview Table**

```sql
CREATE TABLE ProductReview (
    ReviewID INT IDENTITY(1,1) PRIMARY KEY,
    ProductID INT FOREIGN KEY REFERENCES Product(ProductID),
    ReviewText NVARCHAR(1000),
    Rating FLOAT CHECK (Rating BETWEEN 0 AND 5),
    ReviewDate DATETIME DEFAULT GETDATE()
);
```
