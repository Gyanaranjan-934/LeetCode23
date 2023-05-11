//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            int fee=sc.nextInt();
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N,fee);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long arr[], int N, int fee){
        // 2. Tabulation
        long[][] dp = new long[arr.length+1][2];
        
        for(int i=arr.length-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==0){
                    dp[i][j] = Math.max(-arr[i]+dp[i+1][1],dp[i+1][0]);
                }else
                    dp[i][j] = Math.max(arr[i]-fee+dp[i+1][0],dp[i+1][1]);
            }
        }
        return dp[0][0];
    }
}