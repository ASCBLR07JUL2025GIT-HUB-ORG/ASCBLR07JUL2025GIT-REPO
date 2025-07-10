### :dart: Java Method Signature

A **function signature** in Java refers to the method's name and the parameter list (types and order of parameters).  
It does **not** include the return type or exceptions.

---

#### :gear: Basic Structure of a Java Method (Function) Signature

```java
returnType methodName(parameterType1 param1, parameterType2 param2, ...)
```

---

#### :bulb: Example

```java
public int add(int a, int b)
```

- **Method name:** `add`
- **Parameter types and order:** `int, int`
- **Signature:** `add(int, int)`

---

#### :warning: Notes

- Access modifiers (`public`, `private`, etc.) and return types (`int`, `void`, etc.) are **not** part of the signature.
- Method overloading in Java is determined by the method signature.

---