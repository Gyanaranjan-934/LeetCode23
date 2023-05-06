//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // 1. Recursion + Memoization
        long[][] dp = new long[N][sum+1];
        for(long[] row : dp)
            Arrays.fill(row,-1);
        return recFunc(N-1,coins,sum,dp);
    }
    public long recFunc(int ind,int[] arr,int sum,long[][] dp){
        if(ind==0){
            if(sum%arr[ind]==0)return 1;
            return 0;
        }
        if(sum==0)return 1;
        if(dp[ind][sum] != -1) return dp[ind][sum];
        long notPick = recFunc(ind-1,arr,sum,dp);
        long pick = 0;
        if(sum>=arr[ind])
            pick = recFunc(ind,arr,sum-arr[ind],dp);
        
        return dp[ind][sum] = pick+notPick;
    }
}  