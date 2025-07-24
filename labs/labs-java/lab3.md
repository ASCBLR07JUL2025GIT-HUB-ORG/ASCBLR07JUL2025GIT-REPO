# :keyboard: **LAB 3**

---

### :dart: Objectives

- **Organize classes into packages with a clear hierarchy.**
- **Implement constructors, static variables, and read-only fields.**
- **Demonstrate inheritance and use of the `super` keyword.**
- **Concatenate and display object details.**

---

### :rocket: Tasks

#### 1. :gear: Create a `Movie` class

- **Attributes:**  
  - `movieName`  
  - `producedBy`  
  - `directedBy`  
  - `duration`  
  - `year`  
  - `category` (e.g., comedy/action/...)

- **Requirements:**  
  - Write methods to accept and display information.
  - **Constructors:**
    - `movieName` and `producedBy` are **mandatory** and must be supplied when creating the object.
    - Compiler should raise an error if a `Movie` object is created without parameters.
    - Write a constructor that accepts all attributes and calls the mandatory-fields constructor using `this()`.

---

#### 2. :bulb: Static Variable

- In the `Movie` class, create a static variable `moviesCount`.
- Write methods to get its value.
- Increment `moviesCount` every time a `Movie` object is created.

---

#### 3. :shield: Read-Only Field

- Add a `movieId` field (private, read-only, getter only).
- Generate `movieId` as:  
  ```
  movieId = movieName + "_" + moviesCount
  ```
  - Example: If `movieName` is "Hello" and `moviesCount` is 31, then `movieId` is `Hello_31`.

---

#### 4. :triangular_ruler: Inheritance

- **SpecialMovie**: Inherits from `Movie`, adds:
  - `soundEffectsTechnology`
  - `visualEffectsTechnology`
- **InternationalMovie**: Inherits from `Movie`, adds:
  - `country`
  - `language`
- Write constructors and methods for additional info.
- Use `super` to call superclass methods/constructors.

---

#### 5. :test_tube: Show Details

- In `Movie`, write a method `showDetails()` that concatenates all attribute values and returns as a `String`.

---

### :white_check_mark: Example

```java
Movie m = new Movie("Hello", "XYZ Productions");
System.out.println(m.getMovieId()); // Output: Hello_1
```

---