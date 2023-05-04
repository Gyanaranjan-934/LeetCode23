//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int mat[][])
    {
        // 1. Recursion + Memoization
        // int[][] dp = new int[n+1][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // int minPath = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     minPath = Math.max(minPath,recFunc(n-1,i,mat,dp));
        // }
        // return minPath;
        
        // 2. Tabulation
        int[][] dp = new int[n][n];
        
        for(int j=0; j<n; j++){
            dp[0][j] = mat[0][j];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up = mat[i][j] + dp[i-1][j];
                
                int left = mat[i][j];
                if(j>0)left += dp[i-1][j-1];
                
                int right = mat[i][j];
                if(j<n-1)
                    right += dp[i-1][j+1];
                    
                dp[i][j] = Math.max(up,Math.max(left,right));
            }
        }
        int maxi = Integer.MIN_VALUE;
    
        for(int j=0; j<n;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }
        return maxi;
    }
    
    static int recFunc(int r,int c,int[][] mat,int[][] dp){
        if(r==0 && c>=0 && c<mat.length)return mat[r][c];
        
        if(c<0 || c>= mat.length)return (int)Math.pow(10,-9);
        
        if(dp[r][c] != -1)return dp[r][c];
        
        int up = recFunc(r-1,c,mat,dp);
        int left = recFunc(r-1,c-1,mat,dp);
        int right = recFunc(r-1,c+1,mat,dp);
        
        return dp[r][c] = mat[r][c] + Math.max(up,Math.max(left,right));
        
    }
}