#include <bits/stdc++.h> 
using namespace std;

// Directions for moving in a 2D grid (up, right, down, left)
int direction[] = {-1, 0, 1, 0, -1}; 

/**
 * Recursive helper function to find the longest path from (startRow, startCol) to (endRow, endCol).
 * 
 * @param startRow  Current row position
 * @param startCol  Current column position
 * @param endRow    Destination row position
 * @param endCol    Destination column position
 * @param matrix    The grid representing the path (1 = walkable, 0 = obstacle)
 * @return          The maximum path length if a path exists, otherwise INT_MIN
 */
int helper(int startRow, int startCol, int endRow, int endCol, vector<vector<int>> &matrix) {
    // If the current cell is the destination, return 0 (base case)
    if (startRow == endRow && startCol == endCol) {
        return 0;
    }

    // Set default max path length to the smallest possible integer
    int maxPathLength = INT_MIN;

    // Get grid size
    int n = matrix.size(), m = matrix[0].size();

    // Mark the current cell as visited (avoid revisiting in the same path)
    matrix[startRow][startCol] = -1;

    // Explore all four possible directions
    for (int d = 0; d < 4; d++) {
        int newRow = startRow + direction[d];
        int newCol = startCol + direction[d + 1];

        // Check if the new position is within bounds and is a valid path (1)
        if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && matrix[newRow][newCol] == 1) {
            // Recursively find the longest path from this new position
            int currPathLength = 1 + helper(newRow, newCol, endRow, endCol, matrix);
            maxPathLength = max(currPathLength, maxPathLength);
        }
    }

    // Reset the cell to 1 for future backtracking
    matrix[startRow][startCol] = 1;

    return maxPathLength;
}

/**
 * Finds the longest path from (sx, sy) to (dx, dy) in the given matrix.
 * 
 * @param n  Number of rows in the matrix
 * @param m  Number of columns in the matrix
 * @param mat The matrix grid
 * @param sx Start row index
 * @param sy Start column index
 * @param dx Destination row index
 * @param dy Destination column index
 * @return   Longest path length or -1 if no valid path exists
 */
int longestPath(int n, int m, vector<vector<int>> &mat, int sx, int sy, int dx, int dy) {
    // If the start position itself is not walkable, return -1
    if (mat[sx][sy] == 0) {
        return -1;
    }

    int result = helper(sx, sy, dx, dy, mat);
    
    // If no path was found, return -1 instead of INT_MIN
    return (result == INT_MIN) ? -1 : result;
}

int main() {
    int n, m;
    
    // Input matrix dimensions
    cout << "Enter matrix dimensions (n m): ";
    cin >> n >> m;

    vector<vector<int>> mat(n, vector<int>(m));

    // Input the matrix values
    cout << "Enter the matrix (0 for obstacle, 1 for path):\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> mat[i][j];
        }
    }

    int sx, sy, dx, dy;
    
    // Input the starting position
    cout << "Enter start position (sx sy): ";
    cin >> sx >> sy;

    // Input the destination position
    cout << "Enter destination position (dx dy): ";
    cin >> dx >> dy;

    // Find and print the longest path length
    int result = longestPath(n, m, mat, sx, sy, dx, dy);
    if (result == -1) {
        cout << "No valid path found.\n";
    } else {
        cout << "Longest path length: " << result << endl;
    }

    return 0;
}

