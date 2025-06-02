# N-Queens Problem Solver

This project contains a C++ implementation of the classic **N-Queens Problem** using **backtracking and pruning optimizations**.

## 📌 Problem Statement

Place `N` queens on an `N × N` chessboard such that no two queens threaten each other.  
That means:

- No two queens can be in the same row
- No two queens can be in the same column
- No two queens can be on the same diagonal

You are to return **all possible solutions** for a given `n`.

---

## ✅ Function Signature

```cpp
vector<vector<string>> solveNQueens(int n);
🧪 Sample Input and Output
Example 1:
cpp
Copy
Edit
Input:
n = 4

Output:
[
  [".Q..", "...Q", "Q...", "..Q."],
  ["..Q.", "Q...", "...Q", ".Q.."]
]
Each string represents a row on the chessboard, and 'Q' represents a queen.

🚀 How to Run

🔧 Compile
Make sure you have a C++ compiler installed (e.g., g++).

g++ -o nqueens nqueens.cpp
▶️ Execute

./nqueens
You will be prompted to enter n. Then, the program will print all valid board configurations in a JSON-style list.

🧠 Approach
This implementation uses:

Backtracking: Tries placing a queen column by column.

Pruning: Uses three helper arrays to mark attacked rows and diagonals:

leftRow[row] – if the current row is under attack.

upperDiagonal[n - 1 + col - row] – upper-left to bottom-right diagonal.

lowerDiagonal[row + col] – top-right to bottom-left diagonal.

Time Complexity:
Worst case is exponential O(N!) due to backtracking.

Pruning reduces unnecessary recursive calls significantly.

🛠 Example Function Breakdown
solveNQueens(n) – Prepares the board and calls the recursive function.

solve(...) – Core recursive function that places queens and backtracks when necessary.

printFormatted(...) – Outputs solutions in clean "[...]" format.

```
