### :white_check_mark: Core Language Fundamentals

---

#### :triangular_ruler: Syntax and Structure

**Definition:**  
Java syntax refers to the set of rules that defines how Java programs are written and interpreted. It is derived from C/C++ but simplified and structured for robustness and readability.

**How It Works**  
- Java programs are written in classes.
- Each program has a `main` method as the entry point.
- Blocks of code are enclosed in braces `{}`.
- Statements end with semicolons `;`.
- Indentation improves readability (though not syntactically enforced).

**:dart: Value in Development**
- A consistent and readable syntax:
  - Reduces bugs and logic errors.
  - Makes Java easier to learn and maintain.
  - Supports scalability in team-based development.

---

#### :gear: Basic Syntax Structure

```java
// filepath: HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

**:bulb: Recommendations**
- Always match opening `{` with closing `}`.
- Use proper indentation and spacing for readability.
- Avoid deeply nested structures where possible.

---

#### :brain: Comments (Single-line, Multi-line, Documentation)

**Definition:**  
Comments are non-executable notes added to source code to improve clarity and maintainability.

**Types and Syntax**

| Type           | Syntax                | Purpose                      |
|----------------|----------------------|------------------------------|
| Single-line    | `// comment`         | Quick inline notes           |
| Multi-line     | `/* comment */`      | Larger blocks of explanation |
| Documentation  | `/** doc comment */` | API docs (read by javadoc)   |

**Example:**
```java
// This is a single-line comment

/*
 This is a multi-line comment.
 It spans multiple lines.
*/

/**
 * This is a documentation comment.
 * @author Jane
 * @version 1.0
 */
```

**:dart: Value in Development**
- Aids collaboration and future maintenance.
- Enables automated documentation generation.
- Promotes better understanding of complex code.

**:bulb: Recommendations**
- Keep comments concise and relevant.
- Use Javadoc for all public classes and methods.
- Avoid outdated or misleading comments.

---

#### :triangular_ruler: Identifiers and Naming Conventions

**Definition:**  
Identifiers are names used for classes, methods, variables, etc. They must follow Java’s naming rules and best practices.

**Rules**
- Must start with a letter, `$`, or `_`.
- Can contain letters, digits, `$`, and `_`.
- Cannot be a keyword (e.g., `class`, `int`).

**Conventions**

| Entity   | Convention   | Example         |
|----------|--------------|----------------|
| Class    | PascalCase   | `CustomerOrder` |
| Method/Var | camelCase  | `calculateTotal()` |
| Constant | UPPER_SNAKE  | `MAX_LENGTH`   |
| Package  | lowercase    | `com.example.utils` |

**:bulb: Recommendations**
- Be descriptive and avoid abbreviations.
- Follow naming standards to improve readability.
- Avoid starting names with `_` or `$` unless required.

---

#### :rocket: Literals (Integer, Floating-point, Character, String, Boolean)

**Definition:**  
Literals are fixed values directly assigned in code to variables or used in expressions.

**Types and Examples**

| Type           | Examples                      |
|----------------|------------------------------|
| Integer        | `10`, `0xFF`, `0b1010`, `07` |
| Floating-point | `3.14`, `2.0e3`, `1.5f`      |
| Character      | `'A'`, `'\n'`, `'\u0041'`    |
| String         | `"Hello"`, `""`              |
| Boolean        | `true`, `false`              |

**In Practice**
```java
int age = 25;
float pi = 3.14f;
char grade = 'A';
String name = "Alice";
boolean isActive = true;
```

---

#### :gear: Data Types (Primitive and Reference)

**Definition:**  
Java supports two types of data: primitive (basic built-in types) and reference (objects and arrays).

**Primitive Types**

| Type    | Size    | Default Value |
|---------|---------|--------------|
| byte    | 8-bit   | 0            |
| short   | 16-bit  | 0            |
| int     | 32-bit  | 0            |
| long    | 64-bit  | 0L           |
| float   | 32-bit  | 0.0f         |
| double  | 64-bit  | 0.0d         |
| char    | 16-bit  | '\u0000'     |
| boolean | 1-bit   | false        |

**Reference Types**
- Arrays
- Classes
- Interfaces
- Enums

```java
String message = "Welcome";
int[] numbers = {1, 2, 3};
```

---

#### :rocket: Variables (Local, Instance, Static)

**Definition:**  
Variables store data values. Their scope and lifetime depend on their type: local, instance, or static.

**Types**

| Type     | Declared In      | Lifetime    | Access via   |
|----------|------------------|-------------|--------------|
| Local    | Method/block     | Temporary   | Direct       |
| Instance | Class (no static)| Per object  | obj.var      |
| Static   | Class (static)   | Shared      | Class.var    |

```java
public class Counter {
    int count = 0;            // instance
    static int total = 0;     // static

    void increment() {
        int temp = 1;         // local
        count += temp;
        total += temp;
    }
}
```

---

#### :shield: Constants (final keyword)

**Definition:**  
A constant is a variable whose value cannot be changed once assigned, declared using the `final` keyword.

**Syntax**
```java
final int MAX_USERS = 100;
```

**:dart: Value in Development**
- Protects against accidental modification.
- Improves code clarity and maintainability.

---

#### :test_tube: Type Casting and Conversion

**Definition:**  
Type casting converts one data type to another, either implicitly (widening) or explicitly (narrowing).

**Examples**
```java
int x = 10;
double y = x;         // Implicit

double a = 9.8;
int b = (int) a;      // Explicit
```

**:bulb: Best Practice**
- Avoid narrowing conversions unless necessary.
- Use wrapper classes (`Integer.parseInt()`) for string conversions.

---

#### :gear: Operators (Arithmetic, Relational, Logical, Bitwise, Assignment)

| Category    | Operators                | Description                |
|-------------|--------------------------|----------------------------|
| Arithmetic  | `+`, `-`, `*`, `/`, `%`  | Math operations            |
| Relational  | `==`, `!=`, `>`, `<`, etc.| Compare values            |
| Logical     | `&&`, `\|\|`, `!`        | Logical operations         |
| Bitwise     | `&`, `|`, `^`, `~`, `<<` | Bitwise operations         |
| Assignment  | `=`, `+=`, `-=`          | Assign and combine values  |

**Example**
```java
int a = 5, b = 3;
boolean result = (a > b) && (a != 0);
```

---

#### :brain: Expressions and Statements

**Definition:**  
Expressions compute values; statements perform actions.

**Examples**

| Type        | Example                        |
|-------------|-------------------------------|
| Expression  | `a + b * 2`                   |
| Statement   | `System.out.println("Hi");`   |

**:test_tube: Practice**
- Use expressions to build logic.
- Wrap expressions in statements to execute them.

---