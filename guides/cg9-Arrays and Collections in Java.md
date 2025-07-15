### :rocket: Arrays and Collections in Java

Java provides two major ways to store and manipulate data groups: **arrays** and the **Collections Framework**.  
- **Arrays** are fixed-size containers.  
- **Collections** are dynamic and provide richer APIs.

---

### :bulb: Array Declaration and Initialization

**Definition:**  
An array is a container object that holds a fixed number of elements of the same type.

#### **Syntax**
```java
// Declaration
int[] numbers;
String[] names;

// Initialization
numbers = new int[5]; // allocates space for 5 integers
names = new String[]{"Alice", "Bob", "Carol"};
```

**Combined Declaration & Initialization:**
```java
int[] nums = {1, 2, 3, 4, 5};
```

- Arrays are **zero-indexed**.
- Length is **fixed** once created.

---

### :triangular_ruler: Multidimensional Arrays

**Definition:**  
An array of arrays, often used to represent matrices or grids.

#### **Syntax**
```java
int[][] matrix = new int[2][3]; // 2 rows, 3 columns
```

**Initialization:**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

**Ragged Arrays:**
```java
int[][] jagged = new int[3][];
jagged[0] = new int[]{1};
jagged[1] = new int[]{2, 3};
jagged[2] = new int[]{4, 5, 6};
```

---

### :gear: Array Operations and Methods

| Operation | Example Code | Description |
|-----------|--------------|-------------|
| Length    | `arr.length` | Returns number of elements |
| Clone     | `int[] copy = arr.clone();` | Copies the array |
| Sort      | `Arrays.sort(arr);` | Sorts in-place (ascending) |
| Search    | `Arrays.binarySearch(arr, key);` | Must be sorted |
| Fill      | `Arrays.fill(arr, 0);` | Fills with a value |
| Compare   | `Arrays.equals(arr1, arr2);` | Element-wise equality |

**Imports Required:**
```java
import java.util.Arrays;
```

---

### :dart: Collections Framework Overview

**Definition:**  
A set of interfaces and classes for storing and manipulating groups of objects dynamically.

#### **Core Interfaces**

| Interface | Description |
|-----------|-------------|
| List      | Ordered, indexed collection (allows duplicates) |
| Set       | Unordered collection (no duplicates) |
| Map       | Key-value pairs (unique keys) |

**Key Features:**
- Resizable containers
- Sorting, searching, and iteration utilities
- Type-safe with generics

---

### :test_tube: List, Set, Map Interfaces

#### **List<T>**
- Allows duplicates
- Maintains insertion order

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
```

#### **Set<T>**
- No duplicates
- Unordered (`HashSet`) or ordered (`TreeSet`)

```java
Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("Alice");
uniqueNames.add("Alice"); // ignored
```

#### **Map<K, V>**
- Key-value pairs
- No duplicate keys

```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Alice", 30);
ages.put("Bob", 25);
```

---

### :gear: ArrayList, LinkedList, HashMap, TreeMap

| Class      | Ordered | Duplicates | Performance Highlights                |
|------------|---------|------------|---------------------------------------|
| ArrayList  | Yes     | Yes        | Fast random access, slow inserts      |
| LinkedList | Yes     | Yes        | Fast inserts/removals, slow access    |
| HashMap    | N/A     | Keys: No   | Fast lookup, unordered                |
| TreeMap    | Sorted  | Keys: No   | Sorted by keys, slower than HashMap   |

#### **Examples**

**ArrayList:**
```java
List<String> list = new ArrayList<>();
list.add("Java");
list.get(0); // "Java"
```

**LinkedList:**
```java
LinkedList<Integer> ll = new LinkedList<>();
ll.addFirst(10);
ll.addLast(20);
```

**HashMap:**
```java
Map<String, String> capitals = new HashMap<>();
capitals.put("France", "Paris");
capitals.get("France"); // "Paris"
```

**TreeMap:**
```java
TreeMap<String, Integer> sortedMap = new TreeMap<>();
sortedMap.put("B", 2);
sortedMap.put("A", 1); // keys sorted automatically
```

---

### :bulb: Iterator and Enhanced For-Loops

#### **Iterator Interface**
Provides explicit control over collection traversal.

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

#### **for-each Loop**
Simpler alternative for most scenarios.

```java
for (String item : list) {
    System.out.println(item);
}
```

**Use Cases:**
- Use **Iterator** when you need to remove elements during iteration.
- Use **for-each** for read-only traversal.

---

### :white_check_mark: Recommendations and Cautions

#### **Best Practices**
- Use **List** when order matters.
- Use **Set** when uniqueness is required.
- Use **Map** for lookups and associations.
- Use generics (`List<String>`) to enforce type safety.
- Use `Arrays.asList()` to bridge arrays and lists.

#### :warning: **Avoid**
- Modifying collections during enhanced for-loop.
- Using raw types (`List list = new ArrayList();`)
- Using arrays when dynamic sizing is needed.

---

### :brain: Memory Aids

- Arrays = Fixed Size, Collections = Flexible
- List = Linear, Set = Unique, Map = Key-Value
- Use for-each for simplicity, Iterator for control

---

### :triangular_ruler: Alternatives & Related Technologies

| Java Structure | Equivalent In | Notes                        |
|---------------|--------------|------------------------------|
| ArrayList     | Python list   | Similar dynamic behavior     |
| HashMap       | Python dict, JS Object | Similar key-value pairing |
| Set           | Python set    | Unordered, no duplicates     |

---

### :link: Helpful Links

| Topic            | Wikipedia         | Oracle Docs         |
|------------------|------------------|---------------------|
| Java Arrays      | [Array](https://en.wikipedia.org/wiki/Array_data_structure) | [Java Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html) |
| Java Collections | [Java Collections](https://en.wikipedia.org/wiki/Java_collections_framework) | [Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html) |
| List Interface   | —                | [List API](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) |
| Map Interface    | —                | [Map API](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) |