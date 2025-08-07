### :rocket: Java + SQL Server (Authentication: sa / sqlserver)

---

#### :triangular_ruler: STEP 1: Create Database and Table in SQL Server

**Objective:**  
- Create a database and a table with sample data.

**Tool:**  
- SQL Server Management Studio (SSMS)

```sql
-- Create the database
CREATE DATABASE TestDB;
GO

-- Switch to the database
USE TestDB;
GO

-- Create a table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    email VARCHAR(100),
    last_name VARCHAR(100)
);
GO

-- Insert sample data
INSERT INTO Users (user_id, email, last_name)
VALUES 
(1, 'john.doe@example.com', 'Doe'),
(2, 'jane.smith@example.com', 'Smith'),
(3, 'sam.wilson@example.com', 'Wilson');
GO
```

---

#### :gear: STEP 2: Enable SQL Server to Accept JDBC Connections

**Checklist:**  
- [x] **Enable TCP/IP**  
- [x] **Allow Port 1433 Through Firewall**  
- [x] **Enable SQL Server Authentication Mode**  
- [x] **Set SA Password**

**Instructions:**

1. **Enable TCP/IP**  
   - Open SQL Server Configuration Manager  
   - Go to: `SQL Server Network Configuration > Protocols for MSSQLSERVER`  
   - Enable TCP/IP  
   - Double-click TCP/IP, go to IP Addresses  
   - Under IPAll, set:  
     - `TCP Port = 1433`  
   - Restart SQL Server Service

2. **[OPTIONAL] Allow Port 1433 Through Firewall**  
   - Open Windows Defender Firewall with Advanced Security  
   - Create a New Inbound Rule:  
     - Type: Port  
     - Protocol: TCP  
     - Port: 1433  
     - Allow connection  
     - Apply to all profiles (Domain/Private/Public)  
     - Name: Allow SQL Server 1433

3. **Enable SQL Server Authentication Mode**  
   - In SSMS, right-click server > Properties  
   - Go to Security tab  
   - Select SQL Server and Windows Authentication mode  
   - Restart SQL Server

4. **[OPTIONAL] Set SA Password**  
   - In SSMS:

```sql
-- xp_loginconfig is used to check the current login mode.
-- If it returns 'Mixed Mode', SQL Server Authentication is enabled.    
-- xp is a system stored procedure that provides information about the login configuration.
-- the 'login mode' parameter specifies the type of login configuration to check.

EXEC xp_loginconfig  'login mode';
ALTER LOGIN sa WITH PASSWORD = 'sqlserver';
ALTER LOGIN sa ENABLE;
```

---

#### :package: STEP 3: Download & Configure Microsoft JDBC Driver

**Instructions:**  
- Download Microsoft JDBC Driver  
- https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server
- Direct link:
- https://go.microsoft.com/fwlink/?linkid=2325115
- Extract the ZIP  
- Copy: `mssql-jdbc-12.4.2.jre8.jar` (for Java 8)  
- Place it in: `C:\jdbc-driver\`  
- _Note: You do not need `sqljdbc_auth.dll` because you're using SQL Server Authentication._

---

#### :test_tube: STEP 4: Java Program

**File:** `JDBCSelectStatement.java`

```java
import java.sql.*;

public class JDBCSelectStatement {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded!");

            // Connection string using SQL Server Authentication
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;user=sa;password=sqlserver;encrypt=true;trustServerCertificate=true;";
            // The trustedServerCertificate=true option is used to bypass SSL certificate validation for local development. If this is not set, you may encounter SSL errors because the server's certificate is self-signed. Server Certificates are typically used to encrypt the connection between the client and server, ensuring that data transmitted over the network is secure. Setting this to true allows the connection to proceed without validating the server's certificate, which is useful in development environments where you may not have a valid SSL certificate. If not set, you may encounter SSL errors because the server's certificate is self-signed. These are digital certificates used to establish a secure connection between the client and server, ensuring that data transmitted over the network is encrypted and secure. In production, you would typically use a valid certificate issued by a trusted Certificate Authority (CA).
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established!");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users ORDER BY user_id");

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("********");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

---

#### :gear: STEP 5: Compile and Run

**Compile:**
```bash
javac -cp "C:\jdbc-driver\mssql-jdbc-12.4.2.jre8.jar" JDBCSelectStatement.java
```

**Run:**
```bash
java -cp ".;C:\jdbc-driver\mssql-jdbc-12.4.2.jre8.jar" JDBCSelectStatement
```

**Expected Output:**
```text
Driver Loaded!
Connection established!
User ID: 1
Email: john.doe@example.com
Last Name: Doe
********
...
Connection closed.
```

---

#### :dart: Summary of JDBC URL for SQL Server Auth

**JDBC URL Example:**
```text
jdbc:sqlserver://localhost:1433;
databaseName=TestDB;
user=sa;
password=sqlserver;
encrypt=true;
trustServerCertificate=true;
```