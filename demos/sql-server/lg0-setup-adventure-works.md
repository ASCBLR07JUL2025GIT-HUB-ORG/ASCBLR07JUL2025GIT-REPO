# :rocket: AdventureWorks Database Overview

The **AdventureWorks** database is a comprehensive sample database provided by Microsoft that models a fictional company called Adventure Works Cycles, a bicycle manufacturer and distributor. It's used to demonstrate SQL Server features, data modeling, and business processes.

---

### :dart: Domain Overview

- **Industry:** Manufacturing & Sales
- **Core Domains:**
  - Sales & Customer Management
  - Production & Inventory
  - Purchasing & Supply Chain
  - Human Resources
  - Finance & Accounting

---

### :gear: Functional Areas & Key Tables

| Area                | Description                                         | Key Tables                                                                 |
|---------------------|-----------------------------------------------------|----------------------------------------------------------------------------|
| **Sales**           | Manages orders, customers, pricing, and shipping    | `Sales.SalesOrderHeader`, `Sales.Customer`, `Sales.SalesTerritory`         |
| **Production**      | Tracks products, BOMs, work orders, manufacturing   | `Production.Product`, `Production.BillOfMaterials`, `Production.WorkOrder` |
| **Inventory**       | Manages product locations and quantities            | `Production.ProductInventory`, `Production.Location`                       |
| **Purchasing**      | Tracks vendor purchases and receiving               | `Purchasing.PurchaseOrderHeader`, `Purchasing.Vendor`                      |
| **Human Resources** | Manages employees, departments, jobs                | `HumanResources.Employee`, `HumanResources.Department`, `HumanResources.Shift` |
| **Person/Contact**  | Stores names, addresses, contact details            | `Person.Person`, `Person.Address`, `Person.EmailAddress`                   |
| **Finance**         | Deals with currencies, credit cards, pricing        | `Sales.Currency`, `Sales.CreditCard`, `Sales.SpecialOffer`                 |

---

### :brain: Business Processes Modeled

- Customer ordering (B2B/B2C)
- Production planning and manufacturing
- Inventory control and movement
- Vendor procurement
- Employee and payroll data
- Sales territory management and marketing offers

---

### :triangular_ruler: Relationships & ER Model

- **One-to-many:** Customers → Orders
- **Many-to-many:** via junction tables (e.g., product categories and subcategories)
- **Foreign keys:** define natural business constraints (e.g., Order has Customer ID)

---

### :bulb: Editions

- **AdventureWorksLT:** Lightweight, simpler version (Learning/Training)
- **AdventureWorks:** Full version (Business Processes)
- **WideWorldImporters:** Modern sample with OLTP and OLAP model

---

### :rocket: Install AdventureWorks Sample Database in SQL Server 2022

---

#### :bulb: Objectives

- **Install AdventureWorks2022 sample database using .bak file**
- **Verify installation with a sample query**

---

#### :gear: Prerequisites

- **SQL Server 2022 installed**
- **SQL Server Management Studio (SSMS) installed**

---

### :dart: Option 1: Restore AdventureWorks via .bak File

There is no official installer EXE, but you can restore the database easily from a `.bak` file.

---

#### :triangular_ruler: Step 1: Download the Database Backup File (`.bak`)

- Go to the [Microsoft SQL Server sample databases GitHub](https://github.com/Microsoft/sql-server-samples)
- Navigate to:  
  `sql-server-samples/samples/databases/adventure-works/`
- Direct link to **AdventureWorks2022.bak**:  
  [AdventureWorks2022.bak](https://github.com/Microsoft/sql-server-samples/releases/tag/adventureworks)

---

#### :gear: Step 2: Copy `.bak` to SQL Server Backup Folder

- Move the `.bak` file to your default SQL Server backup location, usually:

```plaintext
C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\Backup\
```
- Adjust the path based on your instance name.

---

#### :gear: Step 3: Restore the Database Using SSMS

1. Open **SQL Server Management Studio (SSMS)**
2. Connect to your SQL Server 2022 instance
3. Right-click **Databases** > **Restore Database...**
4. Choose **Device**, click the `[...]` button
5. Add the path to your `.bak` file
6. Click **OK**
7. On the **Files** page, verify database & log file paths
8. Click **OK** to restore

Once done, you’ll see **AdventureWorks2022** in your list of databases.

---

#### :white_check_mark: Verification

You can now query:

```sql
USE AdventureWorks2022;
GO
SELECT TOP 10 * FROM Person.Person;
```

---

#### :test_tube: Alternative: Use `.bacpac` via Azure Data Studio or SSMS

If you prefer the `.bacpac` method for schema + data import, let me know — I can guide you through that too.

---

| **Schema**       | **Description**                                                              |
| ---------------- | ---------------------------------------------------------------------------- |
| `dbo`            | Default schema for objects without a specific schema                         |
| `SalesLT`        | Used in **AdventureWorksLT**; includes tables for sales, customers, products |
| `Person`         | Stores contact info: names, addresses, email addresses                       |
| `Sales`          | Handles sales orders, customers, territories, and related sales data         |
| `Production`     | Manages manufacturing, products, bills of materials, and inventory           |
| `Purchasing`     | Tracks vendors, purchase orders, and receiving                               |
| `HumanResources` | Manages employee data, jobs, shifts, and departments                         |
