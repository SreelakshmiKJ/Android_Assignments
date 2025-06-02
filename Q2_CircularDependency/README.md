# 🔄 Circular Dependency Checker

This project implements a C++ program that detects circular dependencies in a module dependency graph. It is designed as part of an assignment to simulate a real-world module loader system, where each module may depend on one or more other modules.

---

## 🚀 Problem Statement

You are building a module loader for a large software system. Each module may depend on one or more other modules. Before loading, you must ensure that the dependencies do not contain any circular dependency, as that would lead to infinite loading loops.

Given:

- An integer `n` representing the number of modules labeled from `0` to `n - 1`.
- A list of dependency pairs, where each pair `{a, b}` means module `a` depends on module `b`.

### 🧠 Objective

Return `true` if there is a circular dependency, otherwise `false`.

---

## 📥 Input Format

The program accepts runtime input:

1. The number of modules (`n`)
2. The number of dependencies (`m`)
3. `m` lines of dependencies, each as a pair of integers: `a b` (meaning module `a` depends on module `b`)

### ✅ Example Input

Enter number of modules: 4
Enter number of dependencies: 3
Enter dependencies:
0 1
1 2
2 3

### ⛔ Example with Circular Dependency

0 1
1 2
2 0

---

## 💡 Approach

The solution uses **Depth-First Search (DFS)** to detect cycles in a directed graph. Two auxiliary arrays are used:

- `visited[]`: marks whether a node has been visited in any DFS call.
- `inPath[]`: marks whether a node is currently in the recursive stack, indicating a back edge (i.e., a cycle).

---

## 🛠️ How to Run

1. Clone or download the repository.
2. Open in a C++ IDE or VS Code.
3. Compile the code:
   ```bash
   g++ -o cycle_checker main.cpp
   ./cycle_checker
   ```

🧪 Test Cases
| n | Dependencies | Output |
| - | --------------------- | ------|
| 4 | {{0,1}, {1,2}, {2,3}} | false |
| 4 | {{0,1}, {1,2}, {2,0}} | true |
| 3 | {{0,0}} | true |
