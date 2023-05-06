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
    public long count(int coins[], int n, int sum) {
        // 1. Recursion + Memoization
        // long[][] dp = new long[n][sum+1];
        // for(long[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(n-1,coins,sum,dp);
        
        // 2. Tabulation
        long[][] dp = new long[n][sum+1];
        
        for(int i=0;i<=sum;i++)
            if(i%coins[0]==0)
                dp[0][i] = 1;
        
        for(int ind=1;ind<n;ind++){
            for(int j=0;j<=sum;j++){
                long notPick = dp[ind-1][j];
                long pick = 0;
                if(j>=coins[ind])
                    pick = dp[ind][j-coins[ind]];
                
                dp[ind][j] = pick+notPick;
            }
        }
        
        return dp[n-1][sum];
        
    }
    public long recFunc(int ind,int[] arr,int sum,long[][] dp){
        if(ind==0){
            return sum%arr[ind]==0 ? 1 : 0;
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