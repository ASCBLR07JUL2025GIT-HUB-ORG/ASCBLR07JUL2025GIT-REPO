### :rocket: Control Flow Statements in Java

Control flow statements in Java determine the execution path of a program. They allow decisions, looping, and branching to handle dynamic behavior in code.

---

### :bulb: Conditional Statements

#### :gear: if, if-else, and nested if

**Definition:**  
The `if` family of statements executes code blocks based on Boolean conditions.

**Syntax:**
```java
if (condition) {
    // Executes if true
} else if (anotherCondition) {
    // Executes if previous was false and this is true
} else {
    // Executes if all conditions are false
}
```

**Example:**
```java
int score = 85;
if (score >= 90) {
    System.out.println("Grade A");
} else if (score >= 75) {
    System.out.println("Grade B");
} else {
    System.out.println("Grade C");
}
```

**Nested if:**
```java
if (x > 0) {
    if (x < 100) {
        System.out.println("x is between 1 and 99");
    }
}
```

:dart: **Best Practice:**  
Avoid deeply nested ifs—prefer combining conditions or using switch.

---

#### :gear: switch Statement and Expressions

**Definition:**  
The `switch` statement chooses between multiple paths based on the value of a variable. Java 14+ introduced switch expressions.

**Traditional Syntax:**
```java
switch (value) {
    case 1:
        // code
        break;
    case 2:
        // code
        break;
    default:
        // fallback
}
```

**Switch Expression (Java 14+):**
```java
String result = switch (value) {
    case 1 -> "One";
    case 2 -> "Two";
    default -> "Unknown";
};
```

**Example:**
```java
char grade = 'B';
switch (grade) {
    case 'A' -> System.out.println("Excellent");
    case 'B' -> System.out.println("Good");
    case 'C' -> System.out.println("Average");
    default -> System.out.println("Invalid");
}
```

:dart: **Advice:**
- Use `->` syntax to avoid fall-through.
- Always include `default` for robustness.

---

#### :gear: Ternary Operator (`?:`)

**Definition:**  
A compact if-else that returns a value based on a condition.

**Syntax:**
```java
condition ? valueIfTrue : valueIfFalse;
```

**Example:**
```java
int age = 20;
String status = (age >= 18) ? "Adult" : "Minor";
```

:dart: **Use Case:**  
Short, readable conditions.  
:warning: Avoid nesting ternaries—they reduce readability.

---

### :rocket: Loop Structures

#### :gear: for Loop

**Definition:**  
Executes a block a known number of times.

**Syntax:**
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

---

#### :gear: Enhanced for Loop (for-each)

**Definition:**  
Used for iterating collections or arrays.

**Syntax:**
```java
for (String name : names) {
    System.out.println(name);
}
```

:dart: **Use Case:**  
When you don’t need an index.

---

#### :gear: while Loop

**Definition:**  
Executes as long as the condition is true.

**Syntax:**
```java
while (condition) {
    // loop body
}
```

---

#### :gear: do-while Loop

**Definition:**  
Executes at least once, checks the condition after execution.

**Syntax:**
```java
do {
    // loop body
} while (condition);
```

:dart: **Use Case:**  
When initial execution is required regardless of condition.

---

### :warning: break and continue Statements

#### :gear: break

**Definition:**  
Exits the nearest enclosing loop or switch.

**Example:**
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.println(i);
}
```

---

#### :gear: continue

**Definition:**  
Skips current iteration and proceeds to next one.

**Example:**
```java
for (int i = 0; i < 5; i++) {
    if (i == 2) continue;
    System.out.println(i); // skips 2
}
```

---

#### :gear: Labeled Statements

**Definition:**  
Used with break or continue to control flow of nested loops.

**Syntax:**
```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == j) continue outer;
        System.out.println(i + ", " + j);
    }
}
```

:warning: **Advice:**
- Use sparingly—they reduce readability.
- Prefer breaking logic into smaller methods if complexity grows.

---

### :shield: return Statement

**Definition:**  
Terminates the current method and optionally returns a value.

**Syntax:**
```java
return;       // for void methods
return value; // for methods with return types
```

**Example:**
```java
int add(int a, int b) {
    return a + b;
}
```

---

### :white_check_mark: Recommendations and Cautions

**Best Practices:**
- Use `switch` for fixed, enumerable options.
- Keep loops short and focused.
- Prefer enhanced for over index-based loops when index isn't needed.

:warning: **Avoid:**
- Deeply nested if or switch blocks.
- Overusing break/continue — structure loops clearly.
- Complex ternary expressions — split into regular if-else.

---

### :brain: Memory Aids

- `if` = “I’ll Flow” based on true/false.
- `switch` = “Select Which”.

- `?:` = “Yes? Do this : Else do that.”
- `for` = "start; test; change"

---

### :triangular_ruler: Alternatives & Related Technologies

| Java Concept | Comparable In      | Notes                              |
|--------------|--------------------|------------------------------------|
| switch       | C, JavaScript      | Java’s newer switch is expression-based |
| for-each     | Python for         | Java’s enhanced for loop           |
| ternary      | Most C-style languages | Identical use                  |

---

### :link: Helpful Links

| Topic             | Wikipedia                  | Oracle Docs               |
|-------------------|---------------------------|---------------------------|
| Control Flow      | [Control flow](https://en.wikipedia.org/wiki/Control_flow) | [Java Control Flow](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html) |
| Switch Expressions| [Switch](https://en.wikipedia.org/wiki/Switch_statement) | [Java 14 Switch](https://openjdk.org/jeps/361) |
| Loops             | [Loop (Programming)](https://en.wikipedia.org/wiki/Control_flow#Loops) | [Java Loops](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html) |