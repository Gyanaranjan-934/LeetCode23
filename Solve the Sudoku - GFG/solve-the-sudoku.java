//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    static boolean isSafe(int row,int col,int val,int[][] board){
        int drow = (row / 3) * 3;
        int dcol = (col / 3) * 3;

        int srow = row % 3;
        int scol = col % 3;

        // check in submatrix
        for (int i = drow; i < drow + 3; i++) {
            for (int j = dcol; j < dcol + 3; j++) {
                if(board[i][j]==val) return false;               
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if(board[row][i]==val || board[i][col]==val)return false;
        }

        return true;
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int board[][])
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        int ch = k;
                        if (isSafe(i, j, ch, board)) {
                            board[i][j] = ch;
                            if (SolveSudoku(board)) {
                                return true; // Solution found, propagate the result
                            }
                            else board[i][j] = 0; // Revert the value for backtracking
                        }
                    }
                    return false; // No valid value found, backtrack
                }
            }
        }
        return true; // All cells are filled, puzzle is solved
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                System.out.print(grid[i][j]+" ");
    }
}