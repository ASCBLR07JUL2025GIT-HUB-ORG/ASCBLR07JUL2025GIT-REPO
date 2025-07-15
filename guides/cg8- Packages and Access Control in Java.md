### :package: Packages and Access Control in Java

Packages in Java are used to group related classes and interfaces into namespaces, making code more modular, manageable, and reusable. Combined with access control, packages also help enforce encapsulation and secure APIs.

---

### :triangular_ruler: Package Declaration and Organization

**Definition:**  
A package is a namespace for classes, interfaces, enums, and sub-packages, declared using the `package` keyword at the top of a Java file.

**Syntax:**
```java
package com.example.utils;
```

**Rules:**
- Must be the first non-comment line in the file.
- Package name should match the directory structure.

**Example:**
```java
// File: /com/example/utils/MathHelper.java
package com.example.utils;

public class MathHelper {
    public static int square(int x) {
        return x * x;
    }
}
```

**Convention:**  
Use reverse domain names to avoid collisions (e.g., `com.mycompany.project`).

---

### :inbox_tray: Import Statements

**Purpose:**  
Allow classes to use other classes/interfaces from different packages without fully qualifying their names.

#### :dart: Single-Type Import
```java
import java.util.List;
```

#### :dart: On-Demand Import (Wildcard)
```java
import java.util.*; // imports all types in the package (not sub-packages)
```
**Advice:**  
- Prefer explicit imports over wildcard for clarity and to avoid name clashes.

---

### :gear: Static Imports

**Definition:**  
Allows access to static members (fields or methods) without qualifying with the class name.

**Syntax:**
```java
import static java.lang.Math.PI;
import static java.lang.Math.*; // all static members
```

**Example:**
```java
System.out.println(PI);         // instead of Math.PI
System.out.println(pow(2, 3));  // instead of Math.pow(2, 3)
```

:warning: **Warning:**  
Overusing static imports can reduce code clarity—use selectively for constants or utility functions.

---

### :evergreen_tree: Package Hierarchy

Java organizes packages in a hierarchical directory structure. For example:

```
src/
├── com/
│   └── example/
│       ├── Main.java
│       └── utils/
│           └── MathHelper.java
```

**Accessing Across Hierarchy:**
- Classes in sibling or parent packages require import.
- Sub-packages are independent; `com.example.utils` is not a child of `com.example`.

---

### :shield: Access Modifiers

| Modifier      | Class | Same Package | Subclass (diff package) | Everywhere |
|---------------|:-----:|:------------:|:----------------------:|:----------:|
| `public`      |  ✅   |      ✅      |          ✅            |     ✅     |
| `protected`   |  ✅   |      ✅      |          ✅            |     ❌     |
| default (package-private) | ✅ | ✅ | ❌ | ❌ |
| `private`     |  ✅   |      ❌      |          ❌            |     ❌     |

**Use Case Summary:**

| Modifier   | Use When...                                 |
|------------|---------------------------------------------|
| `public`   | Making APIs accessible everywhere           |
| `protected`| Allowing subclass customization while hiding from others |
| default    | Internal usage within a package             |
| `private`  | Hiding implementation details even within the same package |

---

### :eye: Visibility Rules Across Packages

**Key Rules:**
- `public` classes are accessible from anywhere.
- `protected` members are accessible to subclasses, even in other packages.
- Default/package-private members are only accessible within the same package.
- `private` members are accessible only within the same class.

**Example:**
```java
// In com.library
public class Book {
    protected String title; // accessible in subclasses only
}

// In com.app
class EBook extends Book {
    void printTitle() {
        System.out.println(title); // OK, because it's a subclass
    }
}
```

---

### :rocket: CLASSPATH and Package Location

**Definition:**  
CLASSPATH is an environment variable or command-line option that tells the JVM where to find compiled `.class` files.

**Setting via Command Line:**
```bash
javac -cp path/to/libs:. MyApp.java
java -cp path/to/libs:. MyApp
```

**Folder Structure:**  
If you declare:
```java
package com.example.app;
```
Then the source file must be located in:
```
/com/example/app/
```
And compiled with:
```bash
javac -d . com/example/app/MyApp.java
```

**Notes:**
- Tools like Maven or Gradle handle CLASSPATH automatically.
- JAR files can be added to the CLASSPATH using `-cp` or `-classpath`.

---

### :test_tube: Code Examples

**Basic Package + Import:**
```java
// File: com/util/Printer.java
package com.util;

public class Printer {
    public static void print(String msg) {
        System.out.println(msg);
    }
}
```
```java
// File: com/app/Main.java
package com.app;

import com.util.Printer;

public class Main {
    public static void main(String[] args) {
        Printer.print("Hello Packages");
    }
}
```

**Static Import Example:**
```java
import static java.lang.Math.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println(sqrt(16));  // instead of Math.sqrt(16)
    }
}
```

---

### :white_check_mark: Recommendations and Cautions

**Best Practices:**
- Use `public` only when truly necessary.
- Start access with `private` and relax as needed.
- Use consistent, meaningful package naming (e.g., `com.company.project.module`).

**:warning: Avoid:**
- Using wildcard imports in shared libraries.
- Declaring multiple public classes in a single file.
- Ignoring folder-structure-to-package-name alignment.

---

### :brain: Memory Aids

- **"PPSD"** for access: Private, Package-private, Protected, Public (from least to most accessible).
- **Package = Project drawer, Class = Document, Modifier = Access level**
- **CLASSPATH = JVM’s “where do I look?”**

---

### :arrows_counterclockwise: Alternatives & Related Technologies

| Java Feature      | Equivalent In                | Notes                                 |
|-------------------|-----------------------------|---------------------------------------|
| Packages          | Python modules, C++ namespaces | Java requires directory alignment     |
| CLASSPATH         | PYTHONPATH (Python), $PATH   | Similar concept: lookup locations     |
| Access modifiers  | C# (internal, protected)     | C# is stricter in scoping             |

---

### :link: Helpful Links

| Topic             | Wikipedia                  | Oracle Docs                       |
|-------------------|---------------------------|-----------------------------------|
| Java Package      | [Java Package](https://en.wikipedia.org/wiki/Java_package) | [Packages Tutorial](https://docs.oracle.com/javase/tutorial/java/package/index.html) |
| Import Statement  | [Import (programming)](https://en.wikipedia.org/wiki/Import_(programming)) | [Java Import](https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html) |
| Access Modifiers  | [Access Control](https://en.wikipedia.org/wiki/Access_control) | [Controlling Access](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) |
| CLASSPATH         | [CLASSPATH](https://en.wikipedia.org/wiki/Classpath_(Java)) | [Setting the Class Path](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/classpath.html) |