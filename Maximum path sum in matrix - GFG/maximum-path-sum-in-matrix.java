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
        // int[][] dp = new int[n][n+1];
        
        // for(int i=0;i<n;i++){
        //     dp[i][0] = mat[i][0];
        //     dp[0][i] = mat[0][i];
        // }
        // for(int i=0;i<n;i++)
        //     dp[i][n]=(int)Math.pow(10,-9);
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         int up = dp[i-1][j];
        //         int left = (int)Math.pow(10,-9);
        //         if(j>0)
        //             left = dp[i-1][j-1];
        //         int right = dp[i-1][j+1];
                
        //         dp[i][j] = mat[i][j] + Math.max(up,Math.max(left,right));
        //     }
        // }
        // int maxi = Integer.MIN_VALUE;
    
        // for(int j=0; j<n;j++){
        //     maxi = Math.max(maxi,dp[n-1][j]);
        // }
        
        // return maxi;
        
        // 4. Space Optimization
        int[] prev = new int[n];
        
        for(int i=0;i<n;i++)
            prev[i] = mat[0][i];
        
        for(int i=1;i<n;i++){
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                int up = mat[i][j]+prev[j];
                int left = mat[i][j];
                if(j>0) 
                    left += prev[j-1];
                
                int right = mat[i][j];
                if(j<n-1) 
                    right += prev[j+1];
                    
                curr[j] = Math.max(up,Math.max(left,right));
            }
            prev = curr;
        }
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            maxi = Math.max(prev[i],maxi);
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