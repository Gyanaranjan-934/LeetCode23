//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Javahttps://www.geeksforgeeks.org/jobs?tab=studentjobfair

class Solution {
    public int totalWays(int n, int m, int grid[][]) {
        // 1. Recursion
        // return recFunc(m-1,n-1,grid);
        
        // 2. Memoization
        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return memFunc(n-1,m-1,grid,dp);
    }
    public int recFunc(int m,int n,int[][] grid){
        if(m<0 || n<0 || grid[n][m]==1)return 0;
        if(m==0 && n==0)return 1;
        return recFunc(m-1,n,grid)+recFunc(m,n-1,grid);
    }
    public int memFunc(int n,int m,int[][] grid,int[][] dp){
        if(m<0 || n<0 || grid[n][m]==1)return 0;
        if(m==0 && n==0)return 1;
        if(dp[n][m] != -1)return dp[n][m];
        return dp[n][m] = (memFunc(n,m-1,grid,dp)%1000000007+memFunc(n-1,m,grid,dp)%1000000007)%1000000007;
    }
}