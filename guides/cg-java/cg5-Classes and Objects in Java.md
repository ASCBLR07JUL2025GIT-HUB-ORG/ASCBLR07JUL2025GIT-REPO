### :rocket: Classes and Objects in Java

Object-oriented programming in Java centers around classes and objects. A class defines a template; an object is a concrete instance of that template at runtime.

---

### :triangular_ruler: Class Declaration and Definition

**Definition:**  
A class is a blueprint for creating objects that encapsulate data (fields) and behavior (methods).

**Context & Function:**  
Classes are fundamental to Java’s object-oriented structure. Everything (except primitives) is represented using classes.

**Syntax:**
```java
[access_modifier] class ClassName {
    // Fields (instance variables)
    // Methods
}
```

**Example:**
```java
public class Car {
    String color;
    void drive() {
        System.out.println("Driving...");
    }
}
```

**:dart: Recommendations:**
- Use PascalCase for class names.
- Only one public class per file (name must match file name).

---

### :bust_in_silhouette: Object Creation and Instantiation

**Definition:**  
An object is an instance of a class, created using the `new` keyword.

**Syntax:**
```java
Car myCar = new Car();
```

**Example:**
```java
Car car1 = new Car();
car1.color = "Red";
car1.drive();
```

**Notes:**
- Each `new` call allocates memory on the heap.
- Constructor is implicitly called.

---

### :gear: Instance Variables and Methods

**Instance Variables:**  
Defined inside a class, but outside any method. Each object has its own copy.

**Instance Methods:**  
Operate on instance variables. Require an object to be called.

**Example:**
```java
class Student {
    String name;  // instance variable

    void greet() {  // instance method
        System.out.println("Hello, I am " + name);
    }
}
```

**Usage:**
```java
Student s = new Student();
s.name = "Alice";
s.greet();
```

---

### :test_tube: Static Variables and Methods

**Static Members:**  
Belong to the class, not instances. Shared across all objects.

| Feature      | Instance           | Static                        |
|--------------|-------------------|-------------------------------|
| Accessed via | Object            | Class name or object          |
| Stored in    | Heap (per object) | Method area (shared)          |
| Example use  | Object-specific   | Utility or constant fields    |

**Example:**
```java
class Counter {
    static int count = 0; // shared
    int id;               // unique

    Counter() {
        count++;
        id = count;
    }
}
```

**Calling:**
```java
Counter c1 = new Counter();
System.out.println(Counter.count);
```

---

### :building_construction: Constructors

**Definition:**  
Special methods used to initialize objects. They have the same name as the class and no return type.

**Types:**

| Type         | Description                                 |
|--------------|---------------------------------------------|
| Default      | Provided implicitly if no other constructors exist |
| Parameterized| Accepts arguments for custom initialization |
| Copy         | Manually created constructor that clones another object |

**Syntax & Examples:**

**Default Constructor:**
```java
class Box {
    int width;
    Box() {
        width = 10;
    }
}
```

**Parameterized Constructor:**
```java
Box(int w) {
    width = w;
}
```

**Copy Constructor:**
```java
Box(Box b) {
    this.width = b.width;
}
```

---

### :bulb: `this` Keyword

**Definition:**  
Refers to the current object instance within a method or constructor.

**Use Cases:**
- Resolve naming conflicts
- Pass current object as argument
- Chain constructors

**Example:**
```java
class Employee {
    String name;

    Employee(String name) {
        this.name = name; // refers to the instance variable
    }
}
```

**Chaining Constructors:**
```java
Employee() {
    this("Unknown");
}
```

---

### :hourglass_flowing_sand: Object Lifecycle

**Phases:**
1. Instantiation – via `new`.
2. Initialization – constructor runs.
3. Usage – methods and variables accessed.
4. Destruction – object becomes unreachable.
5. Garbage Collection – JVM reclaims memory.

**JVM Role:**  
Java uses automatic garbage collection; destructors are handled by the runtime (not manually coded like in C++).

---

### :floppy_disk: Memory Allocation (Heap vs Stack)

| Aspect       | Heap                        | Stack                        |
|--------------|----------------------------|------------------------------|
| Stores       | Objects, instance variables | Method calls, local variables|
| Lifespan     | Until GC                   | Until method execution ends  |
| Managed by   | JVM Garbage Collector      | Call stack                   |
| Access speed | Slower                     | Faster                       |

**Visualization:**
```java
public class MemoryExample {
    public static void main(String[] args) {
        int x = 10;           // Stack
        Person p = new Person(); // 'p' on Stack, object on Heap
    }
}
```

---

### :book: Code Examples: Increasing Complexity

**Basic:**
```java
class Dog {
    String name;

    void bark() {
        System.out.println(name + " says Woof!");
    }
}

Dog d = new Dog();
d.name = "Buddy";
d.bark();
```

**Intermediate (Constructor and Static):**
```java
class Account {
    static int totalAccounts = 0;
    int id;

    Account() {
        totalAccounts++;
        id = totalAccounts;
    }
}
```

**Advanced (Copy Constructor & Lifecycle):**
```java
class Book {
    String title;

    Book(String title) {
        this.title = title;
    }

    Book(Book b) {
        this.title = b.title;
    }
}
```

---

### :white_check_mark: Recommendations & :warning: Cautions

**Best Practices:**
- Use constructors for required fields.
- Use `this` only when necessary for clarity.
- Use static methods sparingly (utility functions, constants).

**Common Pitfalls:**
- Forgetting to initialize instance variables.
- Overusing static—can break encapsulation and testability.
- Misusing `this` for static contexts.

---

### :brain: Memory Aids

- "Classes are blueprints; objects are houses."
- Use **CPC** to recall constructor types: **Default, Parameterized, Copy**
- `this` = "This object"

---

### :repeat: Alternatives & Related Concepts

| Java Feature   | Outside Java Equivalent                |
|----------------|---------------------------------------|
| Class/Objects  | Python (class), C++ (class)           |
| Constructors   | Python `__init__`, C++ constructor    |
| Memory model   | Similar in .NET, different in Rust    |
| this keyword   | `self` (Python), `this` (JavaScript)  |

---

### :link: Helpful Links

| Concept        | Wikipedia         | Oracle Docs                |
|----------------|------------------|----------------------------|
| Class (Java)   | [Class](https://en.wikipedia.org/wiki/Class_(computer_programming)) | [Java Classes](https://docs.oracle.com/javase/tutorial/java/concepts/class.html) |
| Object (Java)  | [Object](https://en.wikipedia.org/wiki/Object_(computer_science)) | [Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html) |
| this Keyword   | [This](https://en.wikipedia.org/wiki/This_(computer_programming)) | [this Keyword](https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html) |
| Memory Model   | [JVM Memory](https://en.wikipedia.org/wiki/Java_virtual_machine#Memory_management) | [Java Memory Management](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-2.html#jvms-2.5.4) |