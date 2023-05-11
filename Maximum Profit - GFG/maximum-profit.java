//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int arr[]) {
        // 1. Recursion + Memoization
        // int[][][] dp = new int[arr.length+1][2][k+1];
        // for(int[][] mat : dp){
        //     for(int[] row : mat){
        //         Arrays.fill(row,-1);
        //     }
        // }
        // return recFunc(0,arr,1,k,dp);

        // 2. Tabulation
        // int n = arr.length;
        // int[][][] dp = new int[n+1][2][k+1];

        // for(int i=n-1;i>=0;i--){
        //     for(int j=1;j>=0;j--){
        //         for(int l=k;l>=1;l--){
        //             if(j==1){
        //                 dp[i][j][l] = Math.max(-arr[i]+dp[i+1][0][l],dp[i+1][1][l]);
        //             }else{
        //                 dp[i][j][l] = Math.max(arr[i]+dp[i+1][1][l-1],dp[i+1][0][l]);
        //             }
        //         }
        //     }
        // }

        // return dp[0][1][2];

        // 3. Space Optimization
        // int n = arr.length;
        
        // int[][] after = new int[2][k+1];
        // int[][] curr = new int[2][k+1];

        // for(int i=n-1;i>=0;i--){
        //     for(int j=1;j>=0;j--){
        //         for(int l=k;l>=1;l--){
        //             if(j==1){
        //                 curr[j][l] = Math.max(-arr[i]+after[0][l],after[1][l]);
        //             }else{
        //                 curr[j][l] = Math.max(arr[i]+after[1][l-1],after[0][l]);
        //             }
        //         }
        //     }
        //     after = (int[][])(curr.clone());
        // }

        // return after[1][2];

        // Space Optimization 2
        // int n = arr.length;
        int[] after = new int[2*k+1];
        int[] curr  = new int[2*k+1];

        for(int i=n-1;i>=0;i--){
            for(int j=2*k-1;j>=0;j--){
                if(j%2==0){
                    curr[j] = Math.max(-arr[i]+after[j+1],after[j]);
                }else{
                    curr[j] = Math.max(arr[i]+after[j+1],after[j]);
                }
            }
            after = (int[])(curr.clone());
        }

        return after[0];
    }
    public int recFunc(int ind,int[] arr,int buy,int sells_left,int[][][] dp){
        if(sells_left==0 || ind==arr.length)return 0;
        
        if(dp[ind][buy][sells_left]!=-1)return dp[ind][buy][sells_left];

        if(buy==1){
            return dp[ind][buy][sells_left] = Math.max(-arr[ind]+recFunc(ind+1,arr,0,sells_left,dp),recFunc(ind+1,arr,1,sells_left,dp));
        }else{
            return dp[ind][buy][sells_left] = Math.max(arr[ind]+recFunc(ind+1,arr,1,sells_left-1,dp),recFunc(ind+1,arr,0,sells_left,dp));
        }

    }
}