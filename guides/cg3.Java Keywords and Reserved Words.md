## :rocket: Java Keywords and Reserved Words

---

### :shield: Access Modifiers

#### `public`

- **Definition**: `public` is an access modifier that allows the member or class to be accessible from any other class.
- **How it works**: Declaring a method or class as `public` ensures it's visible across all packages. This is essential for APIs and libraries where functionality needs broad accessibility.
- **Value in Development**: Enables modular, reusable components. :warning: Excessive use can expose internal implementation details, reducing encapsulation.

**Syntax:**
```java
public class MyClass {
    public int myValue;
    public void myMethod() {
        // logic
    }
}
```

**:dart: Recommendations:**
- Use `public` sparingly and only when external access is necessary.
- Avoid making class fields public; prefer `private` with getters/setters.

**:bulb: Memory Aid:** Think "`public` = published", open to all readers.

**Alternatives:**

| Modifier   | Accessibility Scope         |
|------------|----------------------------|
| public     | Everywhere                 |
| private    | Same class only            |
| protected  | Same package or subclass   |
| (default)  | Same package only          |

---

**Links:**
- [Oracle Docs - Access Modifiers](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Wikipedia - Java Keywords](https://en.wikipedia.org/wiki/List_of_Java_keywords)

---

### :triangular_ruler: Class-Related Keywords

#### `class`

- **Definition**: The `class` keyword defines a blueprint for objects in Java.
- **How it works**: A class encapsulates data (fields) and behavior (methods). Java uses it to instantiate objects via the `new` keyword.
- **Value in Development:**
  - Fundamental to Object-Oriented Programming (OOP)
  - Supports code reuse through inheritance and composition

**Syntax:**
```java
public class Vehicle {
    String model;
    void start() {
        System.out.println("Starting...");
    }
}
```

**:dart: Recommendations:**
- Use CamelCase for class names (`MyClass`)
- Keep class responsibilities focused (Single Responsibility Principle)

**:bulb: Memory Aid:** Think "`class` = chassis" of the object; the structure.

**Alternatives:** `interface`, `enum`, `record` (Java 14+)

---

**Links:**
- [Oracle Docs - Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- [Wikipedia - Class (Computer Programming)](https://en.wikipedia.org/wiki/Class_(computer_programming))

---

### :gear: Method-Related Keywords

#### `static`

- **Definition**: `static` denotes that a member belongs to the class, rather than instances of it.
- **How it works**: Static fields and methods can be accessed without creating an object. Used for utility methods or constants.
- **Value in Development:**
  - Reduces memory footprint for shared resources
  - Facilitates utility classes (`Math`, `Collections`)

**Syntax:**
```java
public class Utils {
    public static int square(int x) {
        return x * x;
    }
}

int result = Utils.square(5);
```

**:dart: Recommendations:**
- Avoid excessive use to preserve OOP principles
- Use static blocks to initialize static variables

**:bulb: Memory Aid:** Think "`static` = stays with the class"

**Alternatives:** Instance methods, Singleton pattern

---

**Links:**
- [Oracle Docs - Static Keyword](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
- [Wikipedia - Static Variable](https://en.wikipedia.org/wiki/Static_variable)

---

### :test_tube: Control Flow

#### `if`, `else`, `switch`, `case`, `default`, `break`, `continue`

- **Definition**: These keywords govern conditional branching and flow interruption in a program.
- **How it works:**
  - `if`/`else`: conditional logic
  - `switch`/`case`: multi-branch logic
  - `default`: fallback case
  - `break`: exits a loop or switch
  - `continue`: skips to next loop iteration

**Syntax:**
```java
if (x > 0) {
    // positive
} else {
    // non-positive
}

switch (day) {
    case "Mon":
        break;
    default:
        break;
}
```

- **Value in Development:**
  - Simplifies complex logical paths
  - Enhances readability and maintainability

**:dart: Recommendations:**
- Always include a `default` case in switches
- Use `continue` sparingly to maintain clarity

**:bulb: Memory Aid:**
- `if` you need a decision,
- `switch` when you have options

**Alternatives:**
- Polymorphism for behavioral branching
- Strategy pattern for dynamic logic

---

**Links:**
- [Oracle Docs - Control Flow](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)

---

### :shield: Exception Handling

#### `try`, `catch`, `finally`, `throw`, `throws`

- **Definition**: Keywords used for handling errors and exceptional conditions.
- **How it works:**
  - `try`: block of code that may throw exception
  - `catch`: handles specific exception types
  - `finally`: always executed
  - `throw`: explicitly throw an exception
  - `throws`: declare possible exceptions

**Syntax:**
```java
try {
    riskyMethod();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    cleanup();
}

void riskyMethod() throws IOException {
    throw new IOException("Failed");
}
```

- **Value in Development:**
  - Separates error handling from main logic
  - Ensures robust, user-friendly applications

**:dart: Recommendations:**
- Use specific exceptions in `catch`
- Always close resources in `finally` or use try-with-resources

**:bulb: Memory Aid:** try to run, catch problems, finally cleanup

**Alternatives:**
- Optional/Result pattern in functional programming
- Checked vs unchecked exceptions

---

**Links:**
- [Oracle Docs - Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Wikipedia - Exception Handling](https://en.wikipedia.org/wiki/Exception_handling)

---

---

### :repeat: Loop Keywords

#### **for**
**Definition:**  
The `for` keyword defines a loop that repeats a block of code a specific number of times.

**How it works:**  
Used primarily when the number of iterations is known. It consists of an initialization, a condition, and an update expression, all in one line.

**:bulb: Value in development:**  
- Improves readability and control in iterative tasks.
- Excellent for processing arrays or lists.

**Syntax:**
```java
for (initialization; condition; update) {
    // loop body
}
```

**Examples:**

**Basic:**
```java
for (int i = 0; i < 5; i++) {
    System.out.println("Count: " + i);
}
```

**Intermediate (iterating a list):**
```java
List<String> names = List.of("Alice", "Bob", "Charlie");
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}
```

**:dart: Tips & Warnings:**
- Use enhanced for-each loop when index access is not needed.
- :warning: Be cautious of off-by-one errors.

**:brain: Memory Aid:**  
Think “start; test; change”.

**Alternative:**
- `while` loop (when conditions are less structured)
- Stream API (`forEach`) in functional Java

---

#### **while**
**Definition:**  
The `while` keyword creates a loop that continues as long as a specified condition is true.

**How it works:**  
The condition is checked before each iteration. Used when the number of iterations is unknown.

**Syntax:**
```java
while (condition) {
    // loop body
}
```

**Example:**
```java
int count = 0;
while (count < 5) {
    System.out.println("Count is: " + count);
    count++;
}
```

**:dart: Tips:**
- Always ensure the loop condition will eventually become false to avoid infinite loops.

---

#### **do**
**Definition:**  
The `do` keyword defines a loop that executes at least once, checking its condition after the first iteration.

**Syntax:**
```java
do {
    // loop body
} while (condition);
```

**Example:**
```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 3);
```

**:gear: Use case:**  
When the loop body must run at least once regardless of condition.

---

### :triangular_ruler: Object-Oriented Keywords

#### **new**
**Definition:**  
The `new` keyword creates new instances of classes or arrays.

**Example:**
```java
Person p = new Person();
```

**:bulb: Value:**  
Central to object-oriented instantiation and memory management.

---

#### **this**
**Definition:**  
`this` refers to the current instance of the class.

**Usage:**
```java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name; // refers to instance variable
    }
}
```

**:dart: Best Practice:**  
Use `this` when parameter names shadow instance fields.

---

#### **super**
**Definition:**  
Refers to the parent class of the current object, enabling access to superclass methods or constructors.

**Example:**
```java
class Animal {
    void speak() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    void speak() {
        super.speak(); // calls Animal's version
        System.out.println("Dog barks");
    }
}
```

---

#### **instanceof**
**Definition:**  
Checks if an object is an instance of a specific class or implements an interface.

**Syntax:**
```java
if (obj instanceof String) { ... }
```

**:bulb: Note:**  
With Java 16+, use pattern matching for a cleaner approach:
```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

---

### :package: Package-Related Keywords

#### **package**
**Definition:**  
Declares the namespace (package) a class belongs to, used at the very top of a `.java` file.

**Syntax:**
```java
package com.example.myapp;
```

**:dart: Best Practices:**
- Match folder structure to the package declaration.
- Use reversed domain names for uniqueness.

---

#### **import**
**Definition:**  
Allows the use of classes and packages without specifying the full package path.

**Syntax:**
```java
import java.util.List;
```

**Wildcard usage:**
```java
import java.util.*; // imports all classes in the package
```

**:bulb: Advice:**  
Avoid wildcard imports in production; prefer explicit imports for clarity.

---

### :symbols: Other Keywords

#### **void**
**Definition:**  
Indicates that a method does not return any value.

**Syntax:**
```java
public void greet() {
    System.out.println("Hello!");
}
```

---

#### **return**
**Definition:**  
Ends a method and optionally returns a value.

**Example:**
```java
public int add(int a, int b) {
    return a + b;
}
```

---

#### **null**
**Definition:**  
Represents a reference that points to no object.

**Usage:**
```java
String name = null;
```

**:warning: Warning:**  
Accessing methods on a null reference causes a `NullPointerException`.

**:bulb: Alternatives:**
- Use `Optional<T>` (Java 8+) to avoid nulls.

---

#### **true / false**
**Definition:**  
Boolean literals representing the two possible values of a boolean variable.

**Example:**
```java
boolean isActive = true;
```

---

### :white_check_mark: Helpful Links

| Concept         | Wikipedia                        | Oracle Docs                  |
|-----------------|----------------------------------|------------------------------|
| Loops           | [For Loop](https://en.wikipedia.org/wiki/For_loop) | [Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html) |
| OOP             | [Object-Oriented Programming](https://en.wikipedia.org/wiki/Object-oriented_programming) | [Java Language Keywords](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) |
| instanceof      | [Instanceof](https://en.wikipedia.org/wiki/Instanceof) | [instanceof Operator](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html) |
| Package/Import  | [Java Package](https://en.wikipedia.org/wiki/Java_package) | [Packages](https://docs.oracle.com/javase/tutorial/java/package/packages.html) |

---