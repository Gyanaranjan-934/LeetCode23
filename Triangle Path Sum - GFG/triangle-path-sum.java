//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // 1. Recursion + Memoization
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        int minPath = Integer.MAX_VALUE;
        for(int i=0;i<grid.get(n-1).size();i++){
            minPath = Math.min(minPath,recFunc(n-1,i,grid,dp));
        }
        return minPath;
    }
    public static int recFunc(int n,int i,ArrayList<ArrayList<Integer> >grid,int[][] dp){
        if(n==0)return grid.get(0).get(0);
        if(dp[n][i]!=-1)return dp[n][i];
        int up = Integer.MAX_VALUE;
        if(n>i)
            up = grid.get(n).get(i) + recFunc(n-1,i,grid,dp);
        int left = Integer.MAX_VALUE;
        if(i>0)
            left = grid.get(n).get(i) + recFunc(n-1,i-1,grid,dp);
        
        return dp[n][i] = Math.min(up,left);
        
    }
}