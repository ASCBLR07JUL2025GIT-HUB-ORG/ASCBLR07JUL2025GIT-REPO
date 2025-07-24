# :keyboard: **LAB 1**

---

### :rocket: Objectives

- **Practice method overloading and class design**
- **Work with arrays and string manipulation**
- **Implement control structures and loops**

---

### :bulb: 1. Method Overloading

Implement the following methods in a class:

```java
public void add(int a, int b)
```

Invoke these methods by passing appropriate parameters and display the output in the main method.

> :warning: **Hint:** To call `add(short a, short b)` method, you may need to use `add((short)5, (short)6)`

Implement appropriate versions of the `add()` method in a class so that:

- `add(10, 20)` returns `30`
- `add(10, 20, 30)` returns `60`
- `add(10.5, 20.1)` returns `30.6`
- `add("Hello", 20)` returns `"Hello 20"`

---

### :dart: 2. Student Class

Define a class `Student` with the following attributes:

- `studentId` : integer
- `studentName` : String
- `city` : String
- `marks1` : integer
- `marks2` : integer
- `marks3` : integer
- `feePerMonth` : float
- `isEligibleForScholarship` : boolean

#### :gear: Methods

- Setter and getter methods for all attributes
- `getAnnualFee()` : returns `feePerMonth * 12`
- `getTotalMarks()` : returns sum of `marks1`, `marks2`, `marks3`
- `getAverage()` : returns average of `marks1`, `marks2`, `marks3`
- `getResult()` : returns `"pass"` if the person has scored more than 60 in each subject, or `"fail"` otherwise

#### :test_tube: TestMain Class

- Create three `Student` objects
- Populate the objects using setter methods
- Display the name of the student who has the highest total marks
- Print the name and fee of the student who pays the least monthly fee
- Print the name, total marks, average marks, result, and scholarship status for every student

---

### :triangular_ruler: 3. Multiplication Table

Write a method that accepts an integer as parameter and displays its multiplication table using a `for` loop, as shown below. Implement 2 other methods which perform the same action but using a `while` and `do-while` loop respectively.

Example (input: `2`):

```
2 x 1 = 2
2 x 2 = 4
...
2 x 10 = 20
```

---

### :brain: 4. Word Count

Write a method which accepts a string as parameter and returns the number of words in it.

Example:  
Input: `"Sum of 12 and 20 is 32"`  
Output: `4`

---

### :gear: 5. String Class Methods

Create a program with methods to test the functionality of the following `String` class methods:

- `charAt`
- `contains`
- `length`
- `indexOf`
- `equals`
- `equalsIgnoreCase`
- `join`
- `lastIndexOf`
- `substring`
- `toLowerCase`
- `toUpperCase`
- `trim`

---

### :shield: 6. ArrayStore Class

Define a class `ArrayStore` which contains an integer array as its instance variable. Create necessary methods for the following operations:

- Accept 10 integers and store them into the array
- Display the elements of the array using `while` & `for` loops
- Sort the array
- Accept a number and return the number of times it occurs in the array
- Insert a number into the array at a specified position
- Return array that excludes duplicate elements in the original array  
  Example:  
  Input: `[9, 2, 2, 9, 10, 9]`  
  Output: `[9, 2, 10]`

---







