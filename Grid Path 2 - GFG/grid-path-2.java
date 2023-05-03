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
    public int totalWays(int a, int b, int grid[][]) {
        // 1. Recursion
        // return recFunc(b-1,a-1,grid);
        
        // 2. Memoization
        // int[][] dp = new int[a][b];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        
        // return memFunc(a-1,b-1,grid,dp);
        
        // 3. Tabulation
        int[][] dp = new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(grid[i][j]==1)dp[i][j]=-1;
            }
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(i==0 && j==0 && dp[i][j] != -1){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i>0 && dp[i-1][j]!=-1){
                    up = dp[i-1][j];
                }
                if(j>0 && dp[i][j-1]!= -1){
                    left = dp[i][j-1];
                }
                if(dp[i][j]!=-1)
                    dp[i][j] = (up%1000000007+left%1000000007)%1000000007;
            }
        }
        return dp[a-1][b-1]==-1 ? 0 : dp[a-1][b-1];
    }
    public int recFunc(int b,int a,int[][] grid){
        if(b<0 || a<0 || grid[a][b]==1)return 0;
        if(b==0 && a==0)return 1;
        return recFunc(b-1,a,grid)+recFunc(b,a-1,grid);
    }
    public int memFunc(int a,int b,int[][] grid,int[][] dp){
        if(b<0 || a<0 || grid[a][b]==1)return 0;
        if(b==0 && a==0)return 1;
        if(dp[a][b] != -1)return dp[a][b];
        return dp[a][b] = (memFunc(a,b-1,grid,dp)%1000000007+memFunc(a-1,b,grid,dp)%1000000007)%1000000007;
    }
}