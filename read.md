---
### :rocket: Objective

**Prevent Spring Boot from converting camelCase to snake_case in JPA/Hibernate, and use PascalCase for table/column names.**

---

### :gear: Step 1 — Tell Spring Boot to Stop Converting camelCase → snake_case

In your `application.properties`:

```properties
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

:bulb: This makes Hibernate use exactly what you write in `@Column` and `@Table`.

---

### :triangular_ruler: Step 2 — Set PascalCase Directly in Your Entity

```java
@Entity
@Table(name = "Employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "EmailId", nullable = false)
    private String emailId;
}
```

---

### :white_check_mark: Result in SQL Server

**Table:** `Employees`  
**Columns:** `Id`, `FirstName`, `LastName`, `EmailId`

---