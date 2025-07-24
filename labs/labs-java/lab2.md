:keyboard: **LAB 2:**  

---

### :rocket: Objectives

- **Understand** class identification, attributes, methods, and relationships.
- **Practice** writing Java methods for various scenarios.

---

### :bulb: 1. Identify Classes, Attributes, Methods, and Relationships

A company wants to build an application to store the details of their meeting rooms. There are two types of meeting rooms:
- **With Zoom calling facility**
- **Without Zoom calling facility**

#### :dart: Requirements

- All meeting rooms have:
  - Unique identifier
  - Capacity
  - Floor location
- Meeting rooms **with Zoom** also have:
  - Zoom device ID
  - Zoom account ID
- Employees can book meeting rooms by providing:
  - Employee ID
  - Meeting date
  - Meeting time
  - Duration
- All bookings are stored and can be retrieved by date.

---

### :brain: 2. Welcome Message Method

Write a method that accepts the name of a person as a parameter and returns a simple welcome message.

#### :gear: Example

```java
public static String welcomeMessage(String name) {
    return "Hello " + name + ", Welcome to Java World!";
}
```

**Invoke this method from the main method and display the output.**

---

### :triangular_ruler: 3. Largest Number Method

Write a method that accepts 3 numbers as parameters and returns the largest number among them.

#### :gear: Example

```java
public static int largest(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
}
```

---

### :test_tube: 4. Print Digits in Words

Write a method which accepts a 3-digit number and prints its digits in words.

#### :gear: Example

```java
public static void printDigitsInWords(int number) {
    String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String numStr = String.valueOf(number);
    for (char digit : numStr.toCharArray()) {
        System.out.print(words[digit - '0'] + " ");
    }
}
```

**E.g.**  
Input: `951`  
Output: `Nine Five One`

---

:warning: **Note:**  
Use proper class and method structure as per Java conventions.

---