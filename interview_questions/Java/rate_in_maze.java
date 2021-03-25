/*

A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down. 

In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination. Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with a limited number of moves.

Example:
    input:
        {1, 0, 0, 0}
        {1, 1, 0, 1}
        {0, 1, 0, 0}
        {1, 1, 1, 1}
    output:
        {1, 0, 0, 0}
        {1, 1, 0, 0}
        {0, 1, 0, 0}
        {0, 1, 1, 1}

*/

import java.util.*;
public class HelloWorld{
    public static void findPaths(int[][] path, int[][] sol, int row, int column, int n) {
        if(row == n-1 && column == n-1) {
            sol[row][column] = 1;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(sol[i][j]);
                }
                
            }
            System.out.println();
            return;
        }
        
        if(row >= n || column >= n || row < 0 || column < 0 || path[row][column] == 0 || sol[row][column] == 1) {
            return;
        }
        
        sol[row][column] = 1;
        findPaths(path, sol, row-1, column, n);
        findPaths(path, sol, row+1, column, n);
        findPaths(path, sol, row, column-1, n);            
        findPaths(path, sol, row, column+1, n);
        
        sol[row][column] = 0;
            
    }
     
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int[][] path = {
            {1,0,1},
            {1,1,1},
            {1,1,1}
        };
        int[][] sol = new int[n][n];
        findPaths(path, sol, 0, 0, 3);
    }
}