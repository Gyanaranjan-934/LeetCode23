//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int arr[], int n) {
        // 1. Recursion + Memoization
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return recFunc(n-1,n,arr,dp);
    }
    public int recFunc(int ind,int w,int[] arr,int[][] dp){
        if(ind==0){
            return w*arr[0];
        }
        if(dp[ind][w]!=-1)return dp[ind][w];
        int notPick = recFunc(ind-1,w,arr,dp);
        int pick = 0;
        if(w>=ind+1)
            pick = arr[ind] + recFunc(ind,w-(ind+1),arr,dp);
        
        return dp[ind][w] = Math.max(pick,notPick);
        
    }
}