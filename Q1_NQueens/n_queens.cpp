#include <iostream>
#include <vector>
#include <string>
using namespace std;

// Recursive function to place queens column by column
void placeQueen(int col, int size, vector<string> &grid,
                vector<vector<string>> &allSolutions,
                vector<bool> &rowsUsed,
                vector<bool> &diag1Used,
                vector<bool> &diag2Used) // boolean flags to track attack
{
    if (col == size)
    {
        allSolutions.push_back(grid);
        return;
    }

    for (int row = 0; row < size; ++row)
    {
        if (!rowsUsed[row] && !diag1Used[row + col] && !diag2Used[col - row + size - 1])
        {
            // Place a queen
            grid[row][col] = 'Q';
            rowsUsed[row] = diag1Used[row + col] = diag2Used[col - row + size - 1] = true;

            // Move to the next column
            placeQueen(col + 1, size, grid, allSolutions, rowsUsed, diag1Used, diag2Used);

            // Backtrack: Remove the queen
            grid[row][col] = '.';
            rowsUsed[row] = diag1Used[row + col] = diag2Used[col - row + size - 1] = false;
        }
    }
}
// Core function to generate all valid board configurations
vector<vector<string>> generateNQueens(int n)
{
    vector<vector<string>> solutions;
    vector<string> board(n, string(n, '.'));
    vector<bool> occupiedRows(n, false);
    vector<bool> mainDiagonals(2 * n - 1, false); // row + col
    vector<bool> antiDiagonals(2 * n - 1, false); // col - row + n - 1

    placeQueen(0, n, board, solutions, occupiedRows, mainDiagonals, antiDiagonals);
    return solutions;
}
void displaySolutions(const vector<vector<string>> &results)
{
    cout << "[";
    for (size_t i = 0; i < results.size(); ++i)
    {
        cout << "[";
        for (size_t j = 0; j < results[i].size(); ++j)
        {
            cout << "\"" << results[i][j] << "\"";
            if (j != results[i].size() - 1)
                cout << ",";
        }
        cout << "]";
        if (i != results.size() - 1)
            cout << ",";
    }
    cout << "]" << endl;
}
int main()
{
    int boardSize;
    cout << "Enter the board size (n): ";
    cin >> boardSize;

    vector<vector<string>> validArrangements = generateNQueens(boardSize);
    displaySolutions(validArrangements);

    return 0;
}
