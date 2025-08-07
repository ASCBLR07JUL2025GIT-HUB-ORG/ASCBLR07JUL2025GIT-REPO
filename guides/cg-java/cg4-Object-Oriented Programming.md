### :brain: Object-Oriented Programming (OOP) in Java

Java is a fully object-oriented language (except for primitives), and understanding OOP is fundamental to writing robust, scalable, and maintainable Java applications.

---

#### :dart: Core OOP Concepts

- **Classes & Objects**
- **Encapsulation**
- **Inheritance**
- **Polymorphism**
- **Abstraction**
- **Constructors & Destructors**
- **Method Overloading & Overriding**
- **Static vs Instance Members**
- **Access Specifiers & Visibility**

---

### :triangular_ruler: Classes and Objects

**Definition:**  
A class is a blueprint for creating objects; an object is a runtime instance of a class.

**How it works:**  
A class defines state (fields) and behavior (methods). Objects are instantiated from classes using the `new` keyword.

**Value:**  
- Promotes modularity
- Code reuse
- Real-world modeling

**Syntax:**
```java
class Car {
    String color;
    void drive() {
        System.out.println("Driving...");
    }
}

Car myCar = new Car();
myCar.color = "red";
myCar.drive();
```

**:bulb: Tips**
- Keep classes focused (Single Responsibility Principle).
- Avoid creating unnecessary objects (prefer reuse).

---

### :shield: Encapsulation

**Definition:**  
Encapsulation is the practice of restricting direct access to an object's data and exposing it via controlled interfaces.

**How it works:**  
Achieved using `private` fields and public getters/setters.

**Benefits:**
- Protects internal state
- Allows controlled mutation
- Enhances maintainability and debugging

**Example:**
```java
class User {
    private String name;

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null) this.name = name;
    }
}
```

**:brain: Memory Aid:**  
"Capsule": data and code bundled and protected.

---

### :triangular_ruler: Inheritance

**Definition:**  
Inheritance allows a class to acquire properties and methods of another class using the `extends` keyword.

**Syntax:**
```java
class Animal {
    void speak() { System.out.println("Sound"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Woof"); }
}
```

**Benefits:**
- Code reuse
- Hierarchical classification
- Polymorphic behavior

**:warning: Advice**
- Use inheritance only for "is-a" relationships.
- Prefer composition over inheritance when possible.

---

### :rocket: Polymorphism

**Definition:**  
Polymorphism allows objects of different classes to be treated as objects of a common superclass.

**Types in Java:**

| Type                    | Description                                 |
|-------------------------|---------------------------------------------|
| Compile-time (Overloading) | Same method name, different parameters      |
| Runtime (Overriding)        | Subclass modifies inherited method behavior |

**Example (Runtime):**
```java
Animal a = new Dog(); // Polymorphic reference
a.speak(); // Calls Dog's implementation if overridden
```

---

### :gear: Abstraction

**Definition:**  
Abstraction hides complex implementation details and exposes only relevant functionality.

**How it works:**  
Implemented via abstract classes or interfaces in Java.

**Syntax:**
```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    double area() { return Math.PI * radius * radius; }
}
```

**Benefits:**
- Reduces complexity
- Enhances extensibility
- Encourages decoupling

---

### :gear: Constructors and Destructors

**Constructor:**  
Special method used to initialize objects.  
Has the same name as the class and no return type.

**Example:**
```java
class Book {
    String title;
    Book(String title) {
        this.title = title;
    }
}
```

**Destructor (Java style):**
- Java has no explicit destructors.
- Use `finalize()` (deprecated) or rely on Garbage Collection.
- Use `AutoCloseable` and try-with-resources for cleanup.

---

### :test_tube: Method Overloading

**Definition:**  
Multiple methods in the same class with the same name but different parameter lists.

**Purpose:**  
Improves readability and flexibility in method calls.

**Example:**
```java
class MathUtils {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

---

### :test_tube: Method Overriding

**Definition:**  
Subclasses provide a specific implementation of a method declared in a superclass.

**Syntax:**
```java
class Animal {
    void sound() { System.out.println("Generic sound"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("Meow"); }
}
```

**:bulb: Notes**
- Must have the same method signature.
- Use `@Override` to avoid mistakes.

---

### :gear: Static vs Instance Members

| Feature   | Static                | Instance                |
|-----------|----------------------|-------------------------|
| Belongs to| Class                 | Object                  |
| Access    | Via class name/instance| Only via object         |
| Use Case  | Shared utilities/constants | Object-specific state |

**Example:**
```java
class Counter {
    static int count = 0; // shared across all instances
    int id;
    
    Counter() {
        count++;
        id = count;
    }
}
```

**:bulb: Tip**  
Use static for constants, singletons, or utility methods.

---

### :shield: Access Specifiers and Visibility

| Modifier   | Class | Package | Subclass | World |
|------------|:-----:|:-------:|:--------:|:-----:|
| public     |  ✅   |   ✅    |   ✅     |  ✅   |
| protected  |  ✅   |   ✅    |   ✅     |  ❌   |
| (default)  |  ✅   |   ✅    |   ❌     |  ❌   |
| private    |  ✅   |   ❌    |   ❌     |  ❌   |

**Use Cases:**
- `private`: Encapsulation
- `protected`: Controlled inheritance
- `public`: API exposure

**:warning: Advice**  
Start with private and relax visibility only when needed.

---

### :brain: Memory Aids

- **PIE** for OOP Pillars: Polymorphism, Inheritance, Encapsulation
- **Abstraction** hides details, **Encapsulation** hides data
- **“Has-a” vs “Is-a”**: Composition vs Inheritance

---

### :rocket: Alternatives & Related Technologies

| Concept      | Java Alternative         | Outside Java                        |
|--------------|-------------------------|-------------------------------------|
| Abstraction  | interface, abstract class| TypeScript interface, Python ABC    |
| Destruction  | AutoCloseable           | Python `__del__()`, C++ destructors |
| Static utils | static methods          | Singleton pattern, Utility classes  |

---

### :link: Helpful Links

| Concept      | Wikipedia                        | Oracle Docs                        |
|--------------|----------------------------------|------------------------------------|
| OOP          | [Object-Oriented Programming](https://en.wikipedia.org/wiki/Object-oriented_programming) | [Java OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/index.html) |
| Encapsulation| [Encapsulation](https://en.wikipedia.org/wiki/Encapsulation_(computer_programming)) | [Controlling Access to Members](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) |
| Inheritance  | [Inheritance](https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming)) | [Inheritance in Java](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html) |
| Interfaces   | [Interface](https://en.wikipedia.org/wiki/Interface_(computing)) | [Java Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/interfaceDef.html) |

---