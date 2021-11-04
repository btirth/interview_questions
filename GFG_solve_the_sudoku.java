/*

Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]), the task to find a solved Sudoku. For simplicity, you may assume that there will be only one unique solution.

Sample Sudoku for you to get the logic for its solution:

Example 1:
  Input:
    grid[][] = 
    [[3 0 6 5 0 8 4 0 0],
    [5 2 0 0 0 0 0 0 0],
    [0 8 7 0 0 0 0 3 1 ],
    [0 0 3 0 1 0 0 8 0],
    [9 0 0 8 6 3 0 0 5],
    [0 5 0 0 9 0 6 0 0],
    [1 3 0 0 0 0 2 5 0],
    [0 0 0 0 0 0 0 7 4],
    [0 0 5 2 0 6 3 0 0]]
  Output:
    3 1 6 5 7 8 4 9 2
    5 2 9 1 3 4 7 6 8
    4 8 7 6 2 9 5 3 1
    2 6 3 4 1 5 9 8 7
    9 7 4 8 6 3 1 2 5
    8 5 1 7 9 2 6 4 3
    1 3 8 9 4 7 2 5 6
    6 9 2 3 5 1 8 7 4
    7 4 5 2 8 6 3 1 9

Your Task:
  You need to complete the two functions:
    SolveSudoku(): Takes a grid as its argument and returns true if a solution is possible and false if it is not.
    printGrid(): Takes a grid as its argument and prints the 81 numbers of the solved Sudoku in a single line with space separation.

Expected Time Complexity: O(9N*N).
Expected Auxiliary Space: O(N*N).

Constraints:
0 ≤ grid[i][j] ≤ 9

*/



class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        return sudokuSolver(grid, 0, 0);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
        }
    }
    
    static boolean sudokuSolver(int grid[][], int row, int col) {
        if(row >= 9) {
            return true;
        }
        
        int nextRow = row;
        int nextCol = col + 1;
        
        if(nextCol >= 9) {
            nextRow = row+1;
            nextCol = 0;
        }
        
        
        if(grid[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(isValid(grid, row, col, i)) {
                    grid[row][col] = i;
                    if(sudokuSolver(grid, nextRow, nextCol)) {
                        return true;
                    }
                    grid[row][col] = 0;
                }
            }    
        } else {
            if(sudokuSolver(grid, nextRow, nextCol)) {
                return true;
            }
        }
        return false;
    }
    
    
    static boolean isValid(int[][] grid, int row, int col, int val) {
        for(int i=0; i<9; i++) {
            if(grid[row][i] == val || grid[i][col] == val) {
                return false;
            }
        }
        
        int boxR = (row / 3) * 3;
        int boxC = (col / 3) * 3;
        
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(grid[i + boxR][j + boxC] == val) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
}
