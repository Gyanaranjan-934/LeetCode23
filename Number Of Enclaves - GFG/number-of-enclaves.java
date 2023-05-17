//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1}; 
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                dfs(i,0,grid,drow,dcol);
            }
            if(grid[i][m-1]==1){
                dfs(i,m-1,grid,drow,dcol);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1){
                dfs(0,i,grid,drow,dcol);
            }
            if(grid[n-1][i]==1){
                dfs(n-1,i,grid,drow,dcol);
            }
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)cnt++;
            }
        }

        return cnt;
    }
    private void dfs(int r,int c,int[][] grid,int[] drow,int[] dcol){
        int n = grid.length;
        int m = grid[0].length;

        grid[r][c]=2;

        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,drow,dcol);
            }
        }

    }
}